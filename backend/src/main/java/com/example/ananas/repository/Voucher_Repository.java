package com.example.ananas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.ananas.entity.voucher.Voucher;

@Repository
public interface Voucher_Repository extends JpaRepository<Voucher, Integer>, JpaSpecificationExecutor<Voucher> {
    Voucher findVoucherByCode(String code);

    Voucher findVoucherByVoucherId(Integer id);
}
