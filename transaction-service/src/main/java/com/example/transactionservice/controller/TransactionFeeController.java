package com.example.transactionservice.controller;

import com.example.transactionservice.dto.TransactionFeeDTO;
import com.example.transactionservice.dto.TransactionResultDTO;
import com.example.transactionservice.model.Request;
import com.example.transactionservice.model.RequestMulti;
import com.example.transactionservice.model.TransactionFee;
import com.example.transactionservice.model.TransactionResult;
import com.example.transactionservice.service.api.TransactionFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TransactionFeeController {

    @Autowired
    TransactionFeeService transactionFeeService;

    @GetMapping("/fees")
    public List<TransactionFeeDTO> showAllTransactionFees() {
        return transactionFeeService.findAllTransactionFees();
    }

    @GetMapping("/results")
    public List<TransactionResultDTO> showAllTransactionResults() {
        return transactionFeeService.findAllTransactionResults();
    }

    @GetMapping("/fee/{type}")
    public TransactionFee showTransactionFeeByType(@PathVariable String type) {
        TransactionFee transactionFeeByType = transactionFeeService.findTransactionFeeByType(type);

        if (transactionFeeByType == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return transactionFeeByType;
    }

    @GetMapping("/result/{name}")
    public TransactionResult showTransactionResultByName(@PathVariable String name) {
        TransactionResult transactionResultByName = transactionFeeService.findTransactionResultByName(name);

        if (transactionResultByName == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return transactionResultByName;
    }

    @PostMapping("/add-fee")
    public void createNewTransactionFee(@RequestBody TransactionFee transactionFee) {
        transactionFeeService.newTransactionFee(transactionFee);
    }

    @PostMapping("/result")
    public void createNewResultFromOneTransactionType(@RequestBody Request request) {
        transactionFeeService.newTransactionResultByOneType(request);
    }

    @PostMapping("/result-m")
    public void createNewResultFromMultiTypes(@RequestBody RequestMulti requestMulti) {
        transactionFeeService.newTransactionResultByMultipleTypes(requestMulti);
    }
}
