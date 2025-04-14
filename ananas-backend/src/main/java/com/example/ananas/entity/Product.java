package com.example.ananas.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    int productId;

    @Column(name = "product_name")
    String productName;

    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    String description;

    @Column(name = "price")
    double price;

    @Column(name = "discount")
    double discount;

    @Column(name = "sold_quantity", columnDefinition = "int default 0")
    int soldQuantity; //

    @Column(name = "material", columnDefinition = "TEXT")
    String material; // Chất liệu vỏ đồng hồ (thép, titanium, nhựa, v.v.)

    @Column(name = "band_type", columnDefinition = "TEXT")
    String bandType; // Loại dây đeo (da, kim loại, cao su, v.v.)

    @Column(name = "movement_type", columnDefinition = "TEXT")
    String movementType; // Loại máy (Quartz, Automatic, Mechanical, v.v.)

    @Column(name = "water_resistance", columnDefinition = "TEXT")
    String waterResistance; // Chỉ số chống nước (3ATM, 5ATM, v.v.)

    @Column(name = "glass_type", columnDefinition = "TEXT")
    String glassType; // Loại kính (Sapphire, Mineral, Acrylic, v.v.)

    @Column(name = "gender") // giới tính
    String gender;

    @Column(name = "origin") // xuất xứ
    String origin;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference("category-products")
    Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @JsonManagedReference("product-productImages")
    List<Product_Image> productImages;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    List<Review> reviews;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    List<ProductVariant> productVariants;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Instant createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Instant updateAt;

    @PrePersist
    public void handleBeforeCreate() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void handleBeforeUpdate() {
        this.updateAt = Instant.now();
    }

    @Column(name = "saleAt")
    LocalDateTime saleAt;
}
