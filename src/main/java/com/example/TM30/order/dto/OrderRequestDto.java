package com.example.TM30.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRequestDto(
        @JsonProperty("order_id") Long orderId,
        @JsonProperty("qty") Integer quantity,
        @JsonProperty("product_id") Long productId
) {
}
