package com.ega.banking.util;

import com.ega.banking.entity.Account;
import com.ega.banking.repository.AccountRepository;
import com.ega.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class AccountUtil {

    @Autowired
    AccountService accountService;

    public long generateAccountNumber(List<Long> existingNumbers) {
        Random random = new Random();
        long newNumber;

        do {
            newNumber = random.nextInt(900000000) + 100000000;
        } while (existingNumbers.contains(newNumber));

        return newNumber;
    }

    public void addAccount(long bankId, Long accountNumber) {
        Account account = Account.builder()
                .accountId(accountNumber)
                .bankId(bankId)
                .build();
        accountService.addAccountOnUserRegistration(account);
    }
}
