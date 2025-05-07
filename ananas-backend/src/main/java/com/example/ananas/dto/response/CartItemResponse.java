package com.example.ananas.dto.response;

import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse {
    ProductVariantCart product;
    int quantity;
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ProductVariantCart {
        int variantId;
        String productName;
        int productId;
        String color;
        double price;
        String size;
        int stock;
        double discount;
        List<String> images;
    }
}
