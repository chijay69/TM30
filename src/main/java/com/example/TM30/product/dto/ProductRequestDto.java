package com.example.TM30.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductRequestDto(
        @JsonProperty("id") int productId,
        @JsonProperty("name") String productName
) {
}
