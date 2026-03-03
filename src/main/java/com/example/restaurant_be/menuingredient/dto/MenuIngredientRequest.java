package com.example.restaurant_be.menuingredient.dto;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record MenuIngredientRequest(
        @NotNull UUID menuId,

        @NotNull UUID ingredientId,

        @NotNull @DecimalMin("0.0") 
        BigDecimal quantity) {
}
