package com.example.ananas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ananas.entity.Cart;
import com.example.ananas.entity.User;

@Repository
public interface Cart_Repository extends JpaRepository<Cart, Integer> {
    Cart findByUser(User user);

    void deleteByUser(User user);
}
