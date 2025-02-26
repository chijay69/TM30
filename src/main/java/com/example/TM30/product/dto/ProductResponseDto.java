package com.example.TM30.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponseDto(
        @JsonProperty("name") String productName
) {
}
