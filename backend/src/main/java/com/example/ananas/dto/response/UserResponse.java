package com.example.ananas.dto.response;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    int userId;
    String username;
    String email;
    String phone;
    String address;
    String firstname;
    String lastname;
    String avatar;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Boolean isActive;
}
