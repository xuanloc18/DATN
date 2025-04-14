package com.example.ananas.dto.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import jakarta.validation.constraints.*;

import com.example.ananas.entity.order.OrderStatus;
import com.example.ananas.entity.order.PaymentMethod;
import com.example.ananas.entity.order.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {

    Integer id;

    int userId;

    String code;

    BigDecimal totalAmount;

    BigDecimal discount_voucher;

    BigDecimal totalPrice;

    OrderStatus status;

    PaymentMethod paymentMethod;

    PaymentStatus paymentStatus;

    String recipientName;

    String recipientPhone;

    String recipientAddress;

    String description;

    Timestamp createdAt;

    Timestamp updatedAt;

    List<Order_Item_Response> orderItems;
}
