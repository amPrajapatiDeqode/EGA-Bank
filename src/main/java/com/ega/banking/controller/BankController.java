package com.ega.banking.controller;

import com.ega.banking.constants.HttpStatusCodes;
import com.ega.banking.entity.Bank;
import com.ega.banking.error.InvalidBankIdException;
import com.ega.banking.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/add")
    public ResponseEntity<?> addBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
        return ResponseEntity.status(HttpStatusCodes.OK).body(bank);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findBankById(@PathVariable("id") long id) {
        Bank bank = bankService.findBankById(id).orElseThrow(() -> new InvalidBankIdException()); // or else throw exception
        return ResponseEntity.status(HttpStatusCodes.OK).body(bank);
    }
}
