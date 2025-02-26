package com.example.TM30.product.util;

import com.example.TM30.product.dto.ProductResponseDto;
import com.example.TM30.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertProductToDto {
    public ProductResponseDto convertProductToProductResponseDto (Product product){
        return new ProductResponseDto(product.getName());
    }
}
