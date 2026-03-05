package com.example.restaurant_be.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restaurant_be.menu.entity.Menu;
import java.util.Optional;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
    boolean existsByName(String name);

    @Query(value = "SELECT * FROM menus WHERE id = :id", nativeQuery = true)
    Optional<Menu> findByIdIncludingInactive(UUID id);
}
