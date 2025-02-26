package com.example.TM30.product.service;

import com.example.TM30.product.dto.ProductRequestDto;
import com.example.TM30.product.entity.Product;

import java.util.List;

public interface ProductService {

    Product findById(Integer productId);

    List<Product> findAllProducts();

    Product createProduct(ProductRequestDto productRequestDto);

    Product updateProduct(ProductRequestDto productRequestDto);

    String deleteProduct(Integer productId);
}
