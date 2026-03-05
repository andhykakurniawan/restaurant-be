package com.example.restaurant_be.order.dto;

import java.util.UUID;


public record OrderItemRequest( 
        UUID menuId,
        Integer quantity
) {}
