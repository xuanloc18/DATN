package com.example.ananas.dto;

import java.time.Instant;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDTO {
    int messageId;
    int senderId;
    int receiverId;
    String message;
    Instant createdAt;
    String senderName; // Thêm trường này
}
