package com.example.restaurant_be.menuingredient.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record MenuIngredientResponse(
        UUID id,
        UUID menuId,
        String menuName,
        UUID ingredientId,
        String ingredientName,
        BigDecimal quantity,
        boolean is_active
) {}
