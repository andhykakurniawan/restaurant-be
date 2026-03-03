package com.example.restaurant_be.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restaurant_be.menu.entity.Menu;
import java.util.Optional;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
    boolean existsByName(String name);
    Optional<Menu> findByName(String name);
}
