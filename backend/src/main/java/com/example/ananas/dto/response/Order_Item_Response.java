package com.example.ananas.dto.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order_Item_Response {
    int productVariantId;
    int productId;
    String productName;
    String size;
    String color;
    Integer quantity;
    String description;
    double price_original;
    double discount;
    String image;
    BigDecimal price;
}
