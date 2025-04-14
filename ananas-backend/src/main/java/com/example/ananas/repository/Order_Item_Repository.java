package com.example.ananas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ananas.entity.Order_Item;

@Repository
public interface Order_Item_Repository extends JpaRepository<Order_Item, Integer> {}
