package com.example.transactionservice.repository;

import com.example.transactionservice.model.TransactionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionResultRepository extends JpaRepository<TransactionResult, Integer> {

    List<TransactionResult> findAll();
    TransactionResult findByName(String name);
}
