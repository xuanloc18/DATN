package com.example.ananas.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantDTO {

    int stock; // Số lượng tồn kho
    String color; // Màu sắc
    String size; // Độ dài dây đeo (mm)
    Integer variantId;
}
