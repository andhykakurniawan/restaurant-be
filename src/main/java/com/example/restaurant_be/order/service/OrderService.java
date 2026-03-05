package com.example.restaurant_be.order.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.restaurant_be.order.dto.OrderRequest;
import com.example.restaurant_be.order.dto.OrderResponse;
import com.example.restaurant_be.order.entity.Order;
import com.example.restaurant_be.order.entity.Status;
import com.example.restaurant_be.order.repository.OrderRepository;
import com.example.restaurant_be.user.entity.User;
import com.example.restaurant_be.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public OrderResponse findById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        return toResponse(order);
    }

    public OrderResponse create(OrderRequest request) {

        User user = userRepository.findById(request.createdBy())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Order order = new Order();
        order.setOrderCode(generateOrderCode());
        order.setCreatedBy(user);
        order.setStatus(Status.OPEN);
        order.setTotalAmount(BigDecimal.ZERO);

        Order saved = orderRepository.save(order);

        return toResponse(saved);
    }

    public void delete(UUID id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        orderRepository.delete(order);
    }

    public OrderResponse restore(UUID id) {

        Order order = orderRepository.findByIdIncludingInactive(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        if (Boolean.TRUE.equals(order.getIsActive())) {
            throw new IllegalArgumentException("Order already active");
        }

        order.setIsActive(true);

        Order saved = orderRepository.save(order);

        return toResponse(saved);
    }

    private OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getOrderCode(),
                order.getCreatedBy().getId(),
                order.getCreatedBy().getUsername(),
                order.getStatus(),
                order.getTotalAmount());
    }

    private String generateOrderCode() {

        String date = LocalDate.now()
                .format(DateTimeFormatter.BASIC_ISO_DATE);

        String prefix = "ORD-" + date;

        Optional<Order> lastOrder =
                orderRepository.findTopByOrderCodeStartingWithOrderByOrderCodeDesc(prefix);

        int nextNumber = 1;

        if (lastOrder.isPresent()) {

            String lastCode = lastOrder.get().getOrderCode();

            String lastNumber = lastCode.substring(lastCode.length() - 4);

            nextNumber = Integer.parseInt(lastNumber) + 1;
        }

        return prefix + "-" + String.format("%04d", nextNumber);
    }
}