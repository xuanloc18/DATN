package com.example.ananas.entity;

import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    int cartId;

    int sumQuantity; // tổng số lượng mặt hàng

    Double sumPrice; // tổng giá tiền

    @ManyToOne
    @JsonBackReference("user-cart")
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "cart")
    @JsonManagedReference("cart-cartItem") // Đặt tên duy nhất cho tham chiếu này
    List<Cart_Item> cartItem;
}
