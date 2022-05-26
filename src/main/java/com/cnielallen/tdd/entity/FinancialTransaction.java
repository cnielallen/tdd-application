package com.cnielallen.tdd.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinancialTransaction {

    @Id
    private Long id;
    private String accountType;
    private String firstName;
    private String lastName;
    private Long bankAccountNumber;
    private Long financialAccountId;
    private LocalDate transactionDate;
    private BigDecimal transactionAmount;

    public FinancialTransaction copy(FinancialTransaction from) {
        this.setFinancialAccountId(from.getFinancialAccountId());
        this.setTransactionDate(from.getTransactionDate());
        this.setTransactionAmount(from.getTransactionAmount());
        this.setLastName(from.getLastName());
        this.setFirstName(from.getFirstName());
        this.setAccountType(from.getAccountType());
        return this;
    }

}
