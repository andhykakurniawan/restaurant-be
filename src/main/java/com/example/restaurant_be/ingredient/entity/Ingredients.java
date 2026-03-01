package com.example.restaurant_be.ingredient.entity;

import com.example.restaurant_be.common.base.BaseEntity;

import java.math.BigDecimal;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredients")
@SQLDelete(sql = "UPDATE ingredients SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
@Getter
@Setter
@NoArgsConstructor
public class Ingredients extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Unit unit;

    @Column(nullable = false)
    private BigDecimal currentStock = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal minimumStock;

    @Column(nullable = false)
    private BigDecimal costPerUnit;
}
