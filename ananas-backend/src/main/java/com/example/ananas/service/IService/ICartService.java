package com.example.ananas.service.IService;

import java.util.List;

import com.example.ananas.dto.response.CartItemResponse;
import com.example.ananas.entity.Cart;

public interface ICartService {
    void addProductToCart(int userId, int productId, String size, String color, int quantity);

    List<CartItemResponse> getAllCartItem(int userId);

    void deleteCart(int userId);

    Integer getSumQuantity(int userId);

    Double getSumPrice(int userId);

    void deleteByVariantId(int userId, int variantId);

    Cart updateCart(int userId, Cart cart);
}
