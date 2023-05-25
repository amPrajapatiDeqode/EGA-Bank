package com.ega.banking.service;

import com.ega.banking.entity.Bank;
import com.ega.banking.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }

    public Optional<Bank> findBankById(long id) {
        return bankRepository.findById(id);
    }
}
