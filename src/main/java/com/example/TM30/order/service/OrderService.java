package com.example.TM30.order.service;

import com.example.TM30.order.dto.OrderRequestDto;
import com.example.TM30.order.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> allOrders();
    Order createOrder(OrderRequestDto orderRequestDto);
}
