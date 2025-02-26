package com.example.TM30.order.util;

import com.example.TM30.order.dto.OrderResponseDto;
import com.example.TM30.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertToOrderDto {

    public OrderResponseDto convertToResponseDto(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto(order.getId(), order.getQuantity());
        return orderResponseDto;
    }
}
