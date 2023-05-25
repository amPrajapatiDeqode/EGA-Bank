package com.ega.banking.service;

import com.ega.banking.constants.TestConstants;
import com.ega.banking.entity.Bank;
import com.ega.banking.repository.BankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BankServiceTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankService bankService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addBank_ShouldSaveBank() {
        Bank bank = Bank.builder()
                .build();
        when(bankRepository.save(any(Bank.class))).thenReturn(bank);

        bankService.addBank(bank);

        verify(bankRepository, times(1)).save(bank);
    }

    @Test
    void findBankById_ExistingBankId_ShouldReturnBank() {
        long bankId = TestConstants.BANK_ID;
        Bank bank = Bank.builder()
                .build();
        when(bankRepository.findById(bankId)).thenReturn(Optional.of(bank));

        Optional<Bank> result = bankService.findBankById(bankId);

        assertTrue(result.isPresent());
        assertEquals(bank, result.get());
        verify(bankRepository, times(1)).findById(bankId);
    }

    @Test
    void findBankById_NonExistingBankId_ShouldReturnEmptyOptional() {
        long nonExistingBankId = TestConstants.NON_EXISTING_BANK_ID;
        when(bankRepository.findById(nonExistingBankId)).thenReturn(Optional.empty());

        Optional<Bank> result = bankService.findBankById(nonExistingBankId);

        assertFalse(result.isPresent());
        verify(bankRepository, times(1)).findById(nonExistingBankId);
    }
}
