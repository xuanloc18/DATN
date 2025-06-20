package com.example.ananas.dto.response;

import java.math.BigDecimal;
import java.sql.Date;

import com.example.ananas.entity.voucher.DiscountType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoucherResponse {
    String code;
    DiscountType discountType;
    BigDecimal discountValue;
    String description;
    BigDecimal minOrderValue;
    BigDecimal maxDiscount;
    Date startDate;
    Date endDate;
}
