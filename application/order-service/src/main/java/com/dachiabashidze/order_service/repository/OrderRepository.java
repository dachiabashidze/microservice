package com.dachiabashidze.order_service.repository;

import com.dachiabashidze.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long>{
    List<Order> findByUserName(String userName);
}
