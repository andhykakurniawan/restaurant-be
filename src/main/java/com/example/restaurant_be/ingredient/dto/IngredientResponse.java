package com.example.restaurant_be.ingredient.dto;

import java.math.BigDecimal;
import java.util.UUID;
import com.example.restaurant_be.ingredient.entity.Unit;

public record IngredientResponse(
        UUID id,
        String name,
        Unit unit,
        BigDecimal currentStock,
        BigDecimal minimumStock,
        BigDecimal costPerUnit,
        boolean is_active
) {}
