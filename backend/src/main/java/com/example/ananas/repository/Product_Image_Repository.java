package com.example.ananas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ananas.entity.Product;
import com.example.ananas.entity.Product_Image;

@Repository
public interface Product_Image_Repository extends JpaRepository<Product_Image, Integer> {
    List<Product_Image> findAllByProduct(Product product);

    void deleteProduct_ImagesByProduct(Product product);
}
