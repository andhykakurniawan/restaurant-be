package com.example.restaurant_be.order.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restaurant_be.order.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
    @Query(value = "SELECT * FROM order_items WHERE id = :id", nativeQuery = true)
    Optional<OrderItem> findByIdIncludingInactive(UUID id);

    List<OrderItem> findByOrder_Id(UUID orderId);

    Optional<OrderItem> findByOrder_IdAndMenu_Id(UUID orderId, UUID menuId);
}
