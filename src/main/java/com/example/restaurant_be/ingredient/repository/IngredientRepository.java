package com.example.restaurant_be.ingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant_be.ingredient.entity.Ingredients;

import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredients, UUID> {
    boolean existsByName(String name);
    Optional<Ingredients> findByName(String name);
    
}
