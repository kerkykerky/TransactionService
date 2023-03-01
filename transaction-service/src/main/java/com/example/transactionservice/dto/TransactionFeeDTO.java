package com.example.transactionservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionFeeDTO {

    private String transactionFeeType;
    private int transactionFixedFee;
}
