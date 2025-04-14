package com.example.ananas.dto.request;

import java.util.List;

import com.example.ananas.dto.ProductVariantDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreateRequest {
    String productName;
    String description;
    double price;
    double discount;
    String material; // chất liệu
    String category;
    String bandType; // Loại dây đeo (da, kim loại, cao su, v.v.)
    String movementType; // Loại máy (Quartz, Automatic, Mechanical, v.v.)
    String waterResistance; // Chỉ số chống nước (3ATM, 5ATM, v.v.)
    String glassType; // Loại kính (Sapphire, Mineral, Acrylic, v.v.)
    String gender;// giới tính
    String origin; //xuất xứ
    List<ProductVariantDTO> variants; // danh sach ca bien the
}
