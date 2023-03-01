package com.example.transactionservice.repository;

import com.example.transactionservice.model.TransactionFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionFeeRepository extends JpaRepository<TransactionFee, Integer> {

    List<TransactionFee> findAll();
    TransactionFee findTransactionFeeByTransactionFeeType(String feeType);
}
