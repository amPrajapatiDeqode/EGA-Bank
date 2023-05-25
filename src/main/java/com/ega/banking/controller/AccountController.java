package com.ega.banking.controller;

import com.ega.banking.entity.Account;
import com.ega.banking.error.InvalidAccountIdException;
import com.ega.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") long id) {
        return accountRepository.findById(id).orElseThrow(() -> new InvalidAccountIdException());
    }
}
