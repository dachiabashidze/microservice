package com.dachiabashidze.order_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private Integer totalAmount;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
