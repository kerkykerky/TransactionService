package com.example.transactionservice.service.api;

import com.example.transactionservice.dto.TransactionFeeDTO;
import com.example.transactionservice.dto.TransactionResultDTO;
import com.example.transactionservice.model.Request;
import com.example.transactionservice.model.RequestMulti;
import com.example.transactionservice.model.TransactionFee;
import com.example.transactionservice.model.TransactionResult;

import java.util.List;

public interface TransactionFeeService {

    List<TransactionFeeDTO> findAllTransactionFees();

    List<TransactionResultDTO> findAllTransactionResults();

    TransactionFee findTransactionFeeByType(String type);

    TransactionResult findTransactionResultByName(String name);

    void newTransactionResultByOneType(Request request);

    void newTransactionResultByMultipleTypes(RequestMulti requestMulti);

    void newTransactionFee(TransactionFee transactionFee);
}
