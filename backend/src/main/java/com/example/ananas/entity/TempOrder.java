package com.example.ananas.entity;

import java.time.Instant;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "temp-order")
public class TempOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String txnRef;

    int orderId;

    double sumPrice;

    String status;

    private Instant createdAt;

    private Instant updateAt;

    @PrePersist
    public void handleBeforeCreate() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void handleBeforeUpdate() {
        this.updateAt = Instant.now();
    }
}
