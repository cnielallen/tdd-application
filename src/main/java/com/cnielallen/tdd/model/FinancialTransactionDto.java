package com.cnielallen.tdd.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"firstName", "lastName", "bankAccountNumber"})
public class FinancialTransactionDto {

    private Long id;
    private String accountType;
    private Long financialAccountId;
    private LocalDate transactionDate;
    private BigDecimal transactionAmount;
    private String firstName;
    private String lastName;
    private Long bankAccountNumber;
    private String description;
    private String emailAddress;

}
