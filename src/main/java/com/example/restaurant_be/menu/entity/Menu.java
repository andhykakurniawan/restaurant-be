package com.example.restaurant_be.menu.entity;

import com.example.restaurant_be.common.base.BaseEntity;
import java.math.BigDecimal;
import com.example.restaurant_be.category.entity.Category;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menus")
@SQLDelete(sql = "UPDATE menus SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
@Getter
@Setter
@NoArgsConstructor
public class Menu extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = true;

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne
    private Category category;
    
}
