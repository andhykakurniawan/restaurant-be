package com.example.restaurant_be.menu.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record MenuResponse(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        UUID categoryId,
        String categoryName,
        String imageUrl,
        boolean is_available,
        boolean is_active
) {}
