package com.example.restaurant_be.ingredient.dto;

import java.math.BigDecimal;

import com.example.restaurant_be.ingredient.entity.Unit;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IngredientRequest(

        @NotBlank
        String name,

        @NotBlank
        Unit unit,

        @NotNull
        @DecimalMin("0.0")
        BigDecimal currentStock,

        @NotNull
        @DecimalMin("0.0")
        BigDecimal minimumStock,

        @NotNull
        @DecimalMin("0.0")
        BigDecimal costPerUnit
) {}
