package com.example.TM30.controller.orderController;

import com.example.TM30.order.dto.OrderRequestDto;
import com.example.TM30.order.dto.OrderResponseDto;
import com.example.TM30.order.entity.Order;
import com.example.TM30.order.service.OrderService;
import com.example.TM30.order.util.ConvertToOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    private ConvertToOrderDto convertToOrderDto;

    @GetMapping("")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders(){
        List<OrderResponseDto> orderList = orderService.allOrders().stream().map(x-> convertToOrderDto.convertToResponseDto(x)).collect(Collectors.toList()).reversed();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto){
        Order order = orderService.createOrder(orderRequestDto);
        OrderResponseDto responseDto = new OrderResponseDto(order.getId(), order.getQuantity());
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
