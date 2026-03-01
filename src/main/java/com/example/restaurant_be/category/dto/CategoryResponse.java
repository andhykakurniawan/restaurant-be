package com.example.restaurant_be.category.dto;

import java.util.UUID;

public record CategoryResponse(
    UUID id,
    String name,
    String description,
    boolean is_Active
) {}