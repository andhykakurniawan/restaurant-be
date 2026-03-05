package com.example.restaurant_be.order.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.example.restaurant_be.common.base.BaseEntity;
import com.example.restaurant_be.menu.entity.Menu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@SQLDelete(sql = "UPDATE order_items SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
@Getter
@Setter
public class OrderItem extends BaseEntity {
    @JoinColumn(name = "order_id", nullable = false)
    @ManyToOne (fetch = FetchType.LAZY)
    private Order order;

    @JoinColumn(name = "menu_id", nullable = false)
    @ManyToOne (fetch = FetchType.LAZY)
    private Menu menu;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "price_snapshot", nullable = false, precision = 12, scale = 2)
    private BigDecimal priceSnapshot;

    @Column(name = "sub_total", nullable = false, precision = 12, scale = 2)
    private BigDecimal subTotal = BigDecimal.ZERO;

}
