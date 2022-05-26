package com.cnielallen.tdd.service;


import com.cnielallen.tdd.config.JacksonConfig;
import com.cnielallen.tdd.converter.FinancialTransactionConverter;
import com.cnielallen.tdd.data.FinancialTransactionDtoGenerator;
import com.cnielallen.tdd.entity.FinancialTransaction;
import com.cnielallen.tdd.event.TestEvents;
import com.cnielallen.tdd.repository.FinancialTransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(classes = {JacksonConfig.class, FinancialTransactionService.class, FinancialTransactionConverter.class})
public class FinancialTransactionServiceTest {

    @Captor
    ArgumentCaptor<FinancialTransaction> transactionArgumentCaptor;

    private final FinancialTransactionConverter financialTransactionConverter = new FinancialTransactionConverter();
    @Autowired
    private FinancialTransactionService financialTransactionService;

    @MockBean
    private FinancialTransactionRepository financialTransactionRepository;

    @Test
    void shouldSaveNewRecord(){
        var financialTransactionEvent = TestEvents.getRandomFinancialTransactionEvent();
        financialTransactionService.process(financialTransactionEvent);
        verify(financialTransactionRepository, times(1)).save(any());
    }

    @Test
    void shouldUpdateExistingRecord(){
        var id = 123L;
        var existingTransaction = financialTransactionConverter
                .convert(FinancialTransactionDtoGenerator.generateRandomFinancialTransactionDto());
        existingTransaction.setId(id);

        when(financialTransactionRepository.findById(id)).thenReturn(Optional.of(existingTransaction));

        var updateEvent = TestEvents.getRandomFinancialTransactionEvent();
        updateEvent.getData().setId(id);

        financialTransactionService.process(updateEvent);

        verify(financialTransactionRepository).save(transactionArgumentCaptor.capture());

        var savedTransaction = transactionArgumentCaptor.getValue();
        assertThat(savedTransaction.getId()).isEqualTo(id);

    }

}
