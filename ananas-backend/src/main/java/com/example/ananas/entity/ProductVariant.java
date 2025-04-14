package com.example.ananas.entity;

import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product_variant")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_id")
    int variantId;

    @Column(name = "color", columnDefinition = "TEXT")
    String color; // Màu sắc của đồng hồ

    @Column(name = "stock")
    int stock; // Số lượng tồn kho

    @Column(name = "size")
    String size;

    @OneToMany(mappedBy = "productVariant")
    @JsonManagedReference
    @JsonIgnore
    List<Cart_Item> cartItems;

    @OneToMany(mappedBy = "productVariant", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    List<Order_Item> orderItems;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    Product product;
}
