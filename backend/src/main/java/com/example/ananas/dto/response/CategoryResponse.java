package com.example.ananas.dto.response;

import java.time.Instant;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {
    String categoryName;
    String description;
    Instant creatAt;
    Instant updateAt;
}
