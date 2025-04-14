package com.example.ananas.dto.request;

import java.time.Instant;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewRequest {
    int reviewId;
    int rating;
    String comment;
    Instant createdAt;
    int userId;
    int productId;
}
