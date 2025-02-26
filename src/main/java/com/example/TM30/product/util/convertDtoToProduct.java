package com.example.TM30.product.util;

import com.example.TM30.product.dto.ProductRequestDto;
import com.example.TM30.product.entity.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class convertDtoToProduct {
    public Product convertToProduct(ProductRequestDto requestDto){
        Product prod = new Product();
        prod.setId((long) requestDto.productId());
        prod.setName(requestDto.productName());
        return prod;
    }
}
