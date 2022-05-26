package com.cnielallen.tdd.event;

import com.cnielallen.tdd.model.FinancialTransactionDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FinancialTransactionEvent {

    private EventHeader eventHeader;
    private FinancialTransactionDto data;
}
