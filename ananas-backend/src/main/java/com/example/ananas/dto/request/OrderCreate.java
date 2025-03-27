package com.example.ananas.dto.request;

import com.example.ananas.entity.Order_Item;
import com.example.ananas.entity.order.PaymentMethod;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderCreate {

    String code;

    PaymentMethod paymentMethod;

    @NotBlank(message = "Tên người nhận không được để trống")
    String recipientName;

    @NotBlank(message = "Số điện thoại người nhận không được để trống")
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại phải là 10 chữ số")
    String recipientPhone;

    @NotBlank(message = "Địa chỉ người nhận không được để trống")
    String recipientAddress;

    String description;

    @NotEmpty(message = "Danh sách sản phẩm không được để trống")
    List<Order_Items_Create> orderItems;
}
