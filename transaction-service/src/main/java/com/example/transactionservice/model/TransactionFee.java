package com.example.transactionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionFee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String transactionFeeType;
    private int transactionFixedFee;
}
