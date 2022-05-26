package com.cnielallen.tdd.model;

import com.cnielallen.tdd.data.FinancialTransactionDtoGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinancialTransactionDtoTest {

    @Test
    void shouldGenerateMultipleFinancialTransactionDto() {
        var financialTransactionDtos = FinancialTransactionDtoGenerator.generateFinancialTransactionDto(2);
        assertThat(financialTransactionDtos.size()).isEqualTo(2);
        assertThat(financialTransactionDtos.get(0).getFinancialAccountId()).isNotEqualTo(financialTransactionDtos.get(1).getFinancialAccountId());
    }

}
