package com.example.restaurant_be.category.entity;
import com.example.restaurant_be.common.base.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@SQLDelete(sql = "UPDATE categories SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
@Getter
@Setter
@NoArgsConstructor

public class Category extends BaseEntity {
    
    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 1000)
    private String description;
    
}
