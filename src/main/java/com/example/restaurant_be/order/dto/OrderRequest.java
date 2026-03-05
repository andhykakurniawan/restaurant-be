package com.example.restaurant_be.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
    
public record OrderRequest (
    @NotBlank
    String orderCode,

    @NotNull
    UUID createdBy,

    @NotNull
    String status,

    @NotNull
    @DecimalMin("0.0")
    BigDecimal totalAmount
 ) {}
