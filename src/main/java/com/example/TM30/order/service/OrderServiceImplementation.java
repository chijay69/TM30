package com.example.TM30.order.service;

import com.example.TM30.order.dto.OrderRequestDto;
import com.example.TM30.order.entity.Order;
import com.example.TM30.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImplementation implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> allOrders() {
        try {
            List<Order> orders = orderRepository.findAll();
        } catch (Exception exception) {
            log.info(exception.getLocalizedMessage());
        }

        return List.of();
    }

    @Override
    public Order createOrder(OrderRequestDto orderRequestDto) {
        try {
            Order order = new Order();
            order.setId(orderRequestDto.orderId());
            order.setQuantity(orderRequestDto.quantity());
            order.setProductId(order.getProductId());
            Order order1 = orderRepository.save(order);
        }catch (Exception e){
            log.error(" Error occurred trying to save order", e);
        }
        return new Order();
    }
}
