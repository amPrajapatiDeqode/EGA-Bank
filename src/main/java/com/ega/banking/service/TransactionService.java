package com.ega.banking.service;

import com.ega.banking.constants.HttpStatusCodes;
import com.ega.banking.entity.Account;
import com.ega.banking.entity.Transaction;
import com.ega.banking.model.TransactionType;
import com.ega.banking.error.InsufficientBalanceException;
import com.ega.banking.error.InvalidTransactionTypeException;
import com.ega.banking.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Transactional
    public ResponseEntity<?> handleTransaction(Transaction transaction) throws InsufficientBalanceException{

        Account account = accountService.getAccountById(transaction.getAccountId());
        List<Transaction> pastTransactions = account.getTransactions();

        int currentBalance = account.getBalance();
        int updatedBalance;
        if (transaction.getTransactionType().equalsIgnoreCase(TransactionType.DEPOSIT.name())) {
            updatedBalance = currentBalance + transaction.getAmount();
        } else if(transaction.getTransactionType().equalsIgnoreCase(TransactionType.WITHDRAW.name())) {
            if (currentBalance < transaction.getAmount())
                throw new InsufficientBalanceException();
            updatedBalance = currentBalance - transaction.getAmount();
        } else {
            throw new InvalidTransactionTypeException();
        }

        pastTransactions.add(transaction);
        account.setBalance(updatedBalance);

        account.setTransactions(pastTransactions);
        accountService.updateBalanceAndTransactionsInAccount(account);

        transactionRepository.save(transaction);

        return ResponseEntity.status(HttpStatusCodes.OK).body(transaction);
    }
}
