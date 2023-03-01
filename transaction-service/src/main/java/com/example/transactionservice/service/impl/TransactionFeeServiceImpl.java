package com.example.transactionservice.service.impl;

import com.example.transactionservice.dto.TransactionFeeDTO;
import com.example.transactionservice.dto.TransactionResultDTO;
import com.example.transactionservice.model.Request;
import com.example.transactionservice.model.RequestMulti;
import com.example.transactionservice.model.TransactionFee;
import com.example.transactionservice.model.TransactionResult;
import com.example.transactionservice.repository.TransactionFeeRepository;
import com.example.transactionservice.repository.TransactionResultRepository;
import com.example.transactionservice.service.api.TransactionFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionFeeServiceImpl implements TransactionFeeService {

    @Autowired
    TransactionFeeRepository transactionFeeRepository;
    @Autowired
    TransactionResultRepository transactionResultRepository;

    @Override
    public List<TransactionFeeDTO> findAllTransactionFees() {

        return new ArrayList<>(transactionFeeRepository.findAll())
                .stream().map(entity -> TransactionFeeDTO.builder()
                        .transactionFeeType(entity.getTransactionFeeType())
                        .transactionFixedFee(entity.getTransactionFixedFee())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionResultDTO> findAllTransactionResults() {
        return new ArrayList<>(transactionResultRepository.findAll())
                .stream().map(entity -> TransactionResultDTO.builder()
                        .name(entity.getName())
                        .localDate(entity.getLocalDate())
                        .transactionResult(entity.getResult())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public TransactionFee findTransactionFeeByType(String type) {

        return transactionFeeRepository.findTransactionFeeByTransactionFeeType(type);
    }

    @Override
    public TransactionResult findTransactionResultByName(String name) {
        return transactionResultRepository.findByName(name);
    }

    @Override
    public void newTransactionFee(TransactionFee transactionFee) {
        transactionFeeRepository.save(transactionFee);
    }

    @Override
    public void newTransactionResultByOneType(Request request) {

        int result = 0;
        int fixedFee;

        if (transactionFeeRepository.findTransactionFeeByTransactionFeeType(request.getType()) == null) {
            fixedFee = 0;
        } else
            fixedFee = transactionFeeRepository.findTransactionFeeByTransactionFeeType(request.getType()).getTransactionFixedFee();

        result = result + fixedFee;

        TransactionResult build = TransactionResult.builder()
                .name(request.getName())
                .result(result)
                .localDate(LocalDate.now())
                .build();

        transactionResultRepository.save(build);
    }

    @Override
    public void newTransactionResultByMultipleTypes(RequestMulti requestMulti) {

        int result = 0;
        int fixedFee;

        for (var type : requestMulti.getTypes()) {
            if (transactionFeeRepository.findTransactionFeeByTransactionFeeType(type) == null) {
                fixedFee = 0;
            } else
                fixedFee = transactionFeeRepository.findTransactionFeeByTransactionFeeType(type).getTransactionFixedFee();

            result = result + fixedFee;
        }

        TransactionResult build = TransactionResult.builder()
                .name(requestMulti.getName())
                .result(result)
                .localDate(LocalDate.now())
                .build();

        transactionResultRepository.save(build);
    }
}
