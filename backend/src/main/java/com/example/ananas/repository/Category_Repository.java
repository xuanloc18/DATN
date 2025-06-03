package com.example.ananas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ananas.entity.Category;

@Repository
public interface Category_Repository extends JpaRepository<Category, Integer> {
    Category findByCategoryName(String name);
}
