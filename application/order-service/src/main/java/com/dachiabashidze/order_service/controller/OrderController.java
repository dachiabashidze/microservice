package com.dachiabashidze.order_service.controller;

import com.dachiabashidze.order_service.OrderServiceApplication;
import com.dachiabashidze.order_service.entity.Order;
import com.dachiabashidze.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Optional<Order> getOrder(@PathVariable Long orderId){
        return orderService.getOrder(orderId);
    }
    @PostMapping
    public ResponseEntity<Void> addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId){
        return orderService.getOrdersByUserId(userId);
    }
}
