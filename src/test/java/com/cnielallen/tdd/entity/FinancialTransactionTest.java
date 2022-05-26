package com.cnielallen.tdd.entity;

import com.cnielallen.tdd.converter.FinancialTransactionConverter;
import com.cnielallen.tdd.data.FinancialTransactionDtoGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinancialTransactionTest {

    @Test
    void shouldCopyFinancialTransaction(){
        var financialTransactionDto = FinancialTransactionDtoGenerator.generateRandomFinancialTransactionDto();
        var existingFinancialTransaction = new FinancialTransactionConverter().convert(financialTransactionDto);
        var financialTransaction  = new FinancialTransaction().copy(existingFinancialTransaction);

        assertThat(financialTransaction).isEqualToIgnoringGivenFields(existingFinancialTransaction, "id");
    }
}
