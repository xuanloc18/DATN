package com.example.ananas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    int reviewId;

    @Column(name = "rating")
    int rating;

    @Column(name = "comment", columnDefinition = "MEDIUMTEXT")
    String comment;

    @Column(name = "created_at")
    Instant createdAt;

    @Column(name = "user_id")
    int userId;

    @Column(name = "product_id")
    int productId;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    User user;

    @ManyToOne
    @JoinColumn(name = "product_id",insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    Product product;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }
}