package com.cnielallen.tdd.converter;

import com.cnielallen.tdd.entity.FinancialTransaction;
import com.cnielallen.tdd.model.FinancialTransactionDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FinancialTransactionConverter implements Converter<FinancialTransactionDto, FinancialTransaction> {


    @Override
    public FinancialTransaction convert(FinancialTransactionDto financialTransactionDto){
        return FinancialTransaction.builder()
                .financialAccountId(financialTransactionDto.getFinancialAccountId())
                .firstName(financialTransactionDto.getLastName())
                .transactionDate(financialTransactionDto.getTransactionDate())
                .transactionAmount(financialTransactionDto.getTransactionAmount())
                .accountType(financialTransactionDto.getAccountType())
                .build();
    }

}
