package com.example.restaurant_be.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemResponse(
    UUID id,
    UUID menuId,
    String menuName,
    Integer quantity,
    BigDecimal priceSnapshoot,
    BigDecimal subTotal
) {}
