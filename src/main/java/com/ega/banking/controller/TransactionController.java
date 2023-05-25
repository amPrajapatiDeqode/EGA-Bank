package com.ega.banking.controller;

import com.ega.banking.constants.HttpStatusCodes;
import com.ega.banking.entity.Transaction;
import com.ega.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/")
    public ResponseEntity<?> depositMoney(@RequestBody Transaction transaction) {
        return transactionService.handleTransaction(transaction);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllTransaction() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.status(HttpStatusCodes.OK).body(transactions);
    }
}
