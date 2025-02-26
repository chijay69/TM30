package com.example.TM30.product.service;

import com.example.TM30.product.dto.ProductRequestDto;
import com.example.TM30.product.entity.Product;
import com.example.TM30.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Integer productId) {
        try{
            return productRepository.findById(Long.valueOf(productId)).orElseThrow();
        } catch (Exception e) {
            log.error("An error occurred attempting to find product with id: {}, {}",productId, e.getMessage() );
        }
        return new Product();
    }

    @Override
    public List<Product> findAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            return products;
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return List.of();
    }

    @Override
    public Product createProduct(ProductRequestDto productRequestDto) {
        try {
            Product prod = new Product();
            prod.setId((long) productRequestDto.productId());
            prod.setName(productRequestDto.productName());
            Product product = productRepository.save(prod);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Product();
    }

    @Override
    public Product updateProduct(ProductRequestDto productRequestDto) {
        try {
            Product product = productRepository.findById((long) productRequestDto.productId()).orElseThrow();
            product.setName(productRequestDto.productName());
            Product optionalProduct = productRepository.save(product);
            return product;
        } catch (Exception exception) {
            log.error("Error updating. msg: {}", exception.getLocalizedMessage());
        }
        return new Product();
    }

    @Override
    public String deleteProduct(Integer productId) {
        Optional<Product> productOptional = productRepository.findById(Long.valueOf(productId));
        if (productOptional.isEmpty()) {
            log.error("Product with id: {} does not exists", productId);
            return "delete failure";
        }
        Product product = productOptional.get();
        productRepository.delete(product);
        return "delete successful";
    }
}
