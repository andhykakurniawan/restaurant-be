package com.example.restaurant_be.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restaurant_be.order.entity.Order;

import java.util.UUID;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order> findByOrderCode(String orderCode);

    @Query(value = "SELECT * FROM orders WHERE id = :id", nativeQuery = true)
    Optional<Order> findByIdIncludingInactive(UUID id);

    Optional<Order> findTopByOrderCodeStartingWithOrderByOrderCodeDesc(String prefix);
}
