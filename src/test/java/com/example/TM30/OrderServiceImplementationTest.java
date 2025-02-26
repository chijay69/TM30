package com.example.TM30;

import com.example.TM30.order.dto.OrderRequestDto;
import com.example.TM30.order.entity.Order;
import com.example.TM30.order.repository.OrderRepository;
import com.example.TM30.order.service.OrderServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplementationTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImplementation orderService;

    private OrderRequestDto orderRequestDto;
    private Order order1;
    private Order order2;

    @BeforeEach
    public void setUp() {
        orderRequestDto = new OrderRequestDto(1L, 10, 100L);
        order1 = new Order();
        order1.setId(1L);
        order1.setQuantity(10);
        order1.setProductId(100L);

        order2 = new Order();
        order2.setId(2L);
        order2.setQuantity(20);
        order2.setProductId(200L);
    }

    @Test
    public void testAllOrders() {
        List<Order> expectedOrders = Arrays.asList(order1, order2);
        when(orderRepository.findAll()).thenReturn(expectedOrders);

        List<Order> actualOrders = orderService.allOrders();

        assertEquals(expectedOrders.size(), actualOrders.size());
        assertEquals(expectedOrders.get(0).getId(), actualOrders.get(0).getId());
        assertEquals(expectedOrders.get(1).getId(), actualOrders.get(1).getId());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void testCreateOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(order1);

        Order createdOrder = orderService.createOrder(orderRequestDto);

        assertEquals(order1.getId(), createdOrder.getId());
        assertEquals(order1.getQuantity(), createdOrder.getQuantity());
        assertEquals(order1.getProductId(), createdOrder.getProductId());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    public void testAllOrders_repositoryException() {
        when(orderRepository.findAll()).thenThrow(new RuntimeException("Repository error"));

        List<Order> actualOrders = orderService.allOrders();

        assertEquals(0, actualOrders.size()); // Expect empty list on exception
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void testCreateOrder_repositoryException() {
        when(orderRepository.save(any(Order.class))).thenThrow(new RuntimeException("Repository error"));

        Order createdOrder = orderService.createOrder(orderRequestDto);

        assertEquals(null, createdOrder.getId()); // Expect a new empty Order object on exception
        assertEquals(null, createdOrder.getQuantity());
        assertEquals(null, createdOrder.getProductId());
        verify(orderRepository, times(1)).save(any(Order.class));
    }
}