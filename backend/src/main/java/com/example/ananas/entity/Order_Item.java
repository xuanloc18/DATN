package com.example.ananas.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

import com.example.ananas.entity.order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_item")
public class Order_Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderItemId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id", nullable = false)
    Order order;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "variant_id", nullable = false)
    ProductVariant productVariant;

    @Column(name = "quantity", nullable = false)
    Integer quantity;

    @Column(name = "price")
    BigDecimal price;
}
