package com.example.TM30.controller.productController;

import ch.qos.logback.classic.Logger;
import com.example.TM30.product.dto.ProductRequestDto;
import com.example.TM30.product.dto.ProductResponseDto;
import com.example.TM30.product.entity.Product;
import com.example.TM30.product.service.ProductService;
import com.example.TM30.product.util.ConvertProductToDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);

    private ConvertProductToDto productToDto;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto> productList = productService.findAllProducts().stream().map(
                x->productToDto.convertProductToProductResponseDto(x)
        ).collect(Collectors.toList()).reversed();
        logger.info("getAllProducts called.");

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{productID}")
    public ResponseEntity<ProductResponseDto> getProductWithId(@PathVariable int productID){
        Product product = productService.findById(productID);
        ProductResponseDto productResponseDto = new ProductResponseDto(product.getName());
        String log_resp = "Gotten product with "+productID;
        logger.info(log_resp);
        return new ResponseEntity<>(productResponseDto, HttpStatus.FOUND);
    }

    @PostMapping("")
    public ResponseEntity<ProductResponseDto> createNewProduct(@RequestBody ProductRequestDto requestDto) {
        try {
            ProductResponseDto productResponseDto = productToDto.convertProductToProductResponseDto(productService.createProduct(requestDto));
            return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
        } catch (RuntimeException exception) {
            logger.error("Runtime exception occurred. msg: {}", exception.getLocalizedMessage());
            Product product = new Product();
            ProductResponseDto productResponseDto = new ProductResponseDto(product.getName());
            return new ResponseEntity<>(productResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{productID}")
    public ResponseEntity<ProductResponseDto> updateProductWithId(@PathVariable int productID, @RequestBody ProductRequestDto productRequestDto){
        Product product = productService.updateProduct(productRequestDto);
        ProductResponseDto responseDto = productToDto.convertProductToProductResponseDto(product);
        String response = "Updated product with " + productID;
        logger.info(response);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{productID}")
    public ResponseEntity<String> deleteProductWithId(@PathVariable int productID) {
        String response = productService.deleteProduct(productID);
        String resp = "Deleted product with id: " + productID;
        logger.info(resp);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
