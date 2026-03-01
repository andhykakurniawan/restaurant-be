package com.example.restaurant_be.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant_be.category.entity.Category;

import java.util.UUID;
import java.util.Optional; 

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findByName(String name);
    boolean existsByName(String name);
}
