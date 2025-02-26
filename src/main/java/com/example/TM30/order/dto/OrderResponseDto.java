package com.example.TM30.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderResponseDto(
        @JsonProperty("order_id") Long orderId,
        @JsonProperty("qty") Integer quantity
) {
}
