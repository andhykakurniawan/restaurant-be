package com.example.restaurant_be.menuingredient.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant_be.menuingredient.entity.MenuIngredient;

public interface MenuIngredientRepository extends JpaRepository<MenuIngredient, UUID> {
}
