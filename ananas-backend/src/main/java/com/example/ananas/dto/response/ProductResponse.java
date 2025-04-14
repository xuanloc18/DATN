package com.example.ananas.dto.response;

import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    int productId;
    String productName;
    String description;
    double price;
    double discount;
    String material;
    String category;
    int soldQuantity;
    String bandType; // Loại dây đeo (da, kim loại, cao su, v.v.)
    String movementType; // Loại máy (Quartz, Automatic, Mechanical, v.v.)
    String waterResistance; // Chỉ số chống nước (3ATM, 5ATM, v.v.)
    String glassType; // Loại kính (Sapphire, Mineral, Acrylic, v.v.)
    String gender;// giới tính
    String origin; //xuất xứ
    List<String> images;
}
