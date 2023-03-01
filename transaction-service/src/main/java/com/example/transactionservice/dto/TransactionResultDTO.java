package com.example.transactionservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TransactionResultDTO {

    private String name;
    private LocalDate localDate;
    private int transactionResult;
}
