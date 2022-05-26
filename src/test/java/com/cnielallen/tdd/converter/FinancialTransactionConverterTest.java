package com.cnielallen.tdd.converter;

import com.cnielallen.tdd.data.FinancialTransactionDtoGenerator;
import com.cnielallen.tdd.entity.FinancialTransaction;
import com.cnielallen.tdd.model.FinancialTransactionDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class FinancialTransactionConverterTest {

    private final FinancialTransactionConverter financialTransactionConverter = new FinancialTransactionConverter();

    @Test
    void shouldConvertToFinancialTransaction(){
        var financialTransactionDto = FinancialTransactionDtoGenerator.generateRandomFinancialTransactionDto();
        var financialTransaction = financialTransactionConverter.convert(financialTransactionDto);
        assertThat(financialTransaction).isNotNull();

    }

   private void assertFinancialTransactions(FinancialTransaction financialTransaction, FinancialTransactionDto financialTransactionDto){
       assertSoftly( softly -> {
          softly.assertThat(financialTransaction.getId()).isEqualTo(financialTransactionDto.getId());
           softly.assertThat(financialTransaction.getFinancialAccountId()).isEqualTo(financialTransactionDto.getFinancialAccountId());
           softly.assertThat(financialTransaction.getFirstName()).isEqualTo(financialTransactionDto.getFirstName());
           softly.assertThat(financialTransaction.getLastName()).isEqualTo(financialTransactionDto.getLastName());
           softly.assertThat(financialTransaction.getTransactionAmount()).isEqualTo(financialTransactionDto.getTransactionAmount());
           softly.assertThat(financialTransaction.getAccountType()).isEqualTo(financialTransactionDto.getAccountType());
           softly.assertThat(financialTransaction.getTransactionDate()).isEqualTo(financialTransactionDto.getTransactionDate());
           softly.assertThat(financialTransaction.getBankAccountNumber()).isEqualTo(financialTransactionDto.getBankAccountNumber());
       });
   }

}
