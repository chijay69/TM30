package com.example.TM30;

import com.example.TM30.product.dto.ProductRequestDto;
import com.example.TM30.product.entity.Product;
import com.example.TM30.product.repository.ProductRepository;
import com.example.TM30.product.service.ProductService;
import com.example.TM30.product.service.ProductServiceImplementation;
import com.example.TM30.product.util.convertDtoToProduct;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ProductServiceTest {

    @Mock
    private ProductService service;

    @Mock
    private ProductRepository productRepository;

    private ProductRequestDto productRequestDto;

    private final List<Product> productList = new ArrayList<>();

    @InjectMocks
    private ProductServiceImplementation productService;

    private static final Integer prodID = 84;

    private static final String prodName = "Indomie noodles";


    public Product convertToProduct(ProductRequestDto requestDto){
        Product prod = new Product();
        prod.setId((long) requestDto.productId());
        prod.setName(requestDto.productName());
        return prod;
    }





    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        productRequestDto = new ProductRequestDto(prodID, prodName);
        Product product = new Product();
        product.setId((long) productRequestDto.productId());
        product.setName(productRequestDto.productName());
        productRepository.save(product);

        ProductRequestDto productRequestDto1 = new ProductRequestDto(132, "Gala");
        ProductRequestDto productRequestDto2 = new ProductRequestDto(453, "Yale");
        ProductRequestDto productRequestDto3 = new ProductRequestDto(982, "Sprite");

        productList.add(convertToProduct(productRequestDto1));
        productList.add(convertToProduct(productRequestDto2));
        productList.add(convertToProduct(productRequestDto3));

    }

    @Test
    public void getAllProductServiceTest (){
        when(productRepository.findAll()).thenReturn(productList);
        List<?> products = productService.findAllProducts();
        assertEquals(ArrayList.class, products.getClass());
    }

    @Test
    public void getProductWithId () {
        Product product = new Product();
        product.setId((long) productRequestDto.productId());
        product.setName(productRequestDto.productName());
        when(productRepository.findById((long) prodID)).thenReturn(Optional.of(product));

        productService.findById(productRequestDto.productId());

    }

}
