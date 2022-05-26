package com.cnielallen.tdd.service;

import com.cnielallen.tdd.converter.FinancialTransactionConverter;
import com.cnielallen.tdd.entity.FinancialTransaction;
import com.cnielallen.tdd.event.FinancialTransactionEvent;
import com.cnielallen.tdd.model.FinancialTransactionDto;
import com.cnielallen.tdd.repository.FinancialTransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FinancialTransactionService {

    private final FinancialTransactionRepository financialTransactionRepository;
    private final FinancialTransactionConverter financialTransactionConverter;

    public void process(FinancialTransactionEvent financialTransactionEvent){
        var financialTransactionEventEventHeader = financialTransactionEvent.getEventHeader();
        var financialTransactionDto = financialTransactionEvent.getData();
        financialTransactionRepository.findById(financialTransactionDto.getId()).ifPresentOrElse(existingTransaction -> {
                    updateExistingAttributes(existingTransaction, financialTransactionDto);
                    financialTransactionRepository.save(existingTransaction);
                    log.info("Financial Transaction Already exists for transaction id {}, updating the transaction", financialTransactionDto.getId());
                }, () -> {
            financialTransactionRepository.save(financialTransactionConverter.convert(financialTransactionDto));
            log.info("Successfully saved a financial transaction for transaction id: {}", financialTransactionDto.getId());
        });


    }

    private void updateExistingAttributes(FinancialTransaction financialTransaction, FinancialTransactionDto financialTransactionDto) {
        financialTransaction.setTransactionAmount(financialTransactionDto.getTransactionAmount());
        financialTransaction.setAccountType(financialTransactionDto.getAccountType());
        financialTransaction.setFirstName(financialTransactionDto.getFirstName());
        financialTransaction.setLastName(financialTransactionDto.getLastName());
        financialTransaction.setBankAccountNumber(financialTransactionDto.getBankAccountNumber());
        financialTransaction.setTransactionAmount(financialTransactionDto.getTransactionAmount());
        financialTransaction.setTransactionDate(financialTransactionDto.getTransactionDate());
        financialTransaction.setFinancialAccountId(financialTransactionDto.getFinancialAccountId());
    }
}
