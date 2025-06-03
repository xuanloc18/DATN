package com.example.ananas.config;

import org.springframework.data.jpa.domain.Specification;

import com.example.ananas.entity.Product;

public class ProductSpecification {

    public static Specification<Product> searchByName(String search) {
        return (root, query, criteriaBuilder) -> {
            if (search == null || search.isEmpty()) {
                return criteriaBuilder.conjunction(); // trả về điều kiện true, không lọc gì cả
            }

            // Kiểm tra nếu tìm kiếm theo cú pháp like
            if (search.startsWith("productName:like:")) {
                String keyword = search.replace("productName:like:", "");
                return criteriaBuilder.like(root.get("productName"), "%" + keyword + "%");
            }

            return criteriaBuilder.conjunction(); // Trả về điều kiện mặc định nếu không khớp
        };
    }
}
