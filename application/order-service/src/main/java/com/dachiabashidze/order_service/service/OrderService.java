package com.dachiabashidze.order_service.service;

import com.dachiabashidze.order_service.entity.Order;
import com.dachiabashidze.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;

    }
    public void addOrder(Order order){
        orderRepository.save(order);
    }
    public Optional<Order> getOrder(Long orderId){
        return orderRepository.findById(orderId);
    }
    public List<Order> getAllOrders() {

        return new ArrayList<>(orderRepository.findAll());
    }
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Order> getOrderByUserName(String userName) {
        return new ArrayList<>(orderRepository.findByUserName(userName));
    }

}
