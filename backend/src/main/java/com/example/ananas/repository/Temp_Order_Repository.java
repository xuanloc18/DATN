package com.example.ananas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.ananas.entity.TempOrder;

@Repository
public interface Temp_Order_Repository extends JpaRepository<TempOrder, Integer>, JpaSpecificationExecutor<TempOrder> {
    TempOrder findByTxnRef(String txnref);
}
