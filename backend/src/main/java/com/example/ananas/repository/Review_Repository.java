package com.example.ananas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ananas.entity.Review;

@Repository
public interface Review_Repository extends JpaRepository<Review, Integer> {
    List<Review> findByProductId(int productId);
}
