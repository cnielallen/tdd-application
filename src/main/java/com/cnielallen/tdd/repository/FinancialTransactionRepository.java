package com.cnielallen.tdd.repository;

import com.cnielallen.tdd.entity.FinancialTransaction;
import com.cnielallen.tdd.model.FinancialTransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long> {
    List<FinancialTransaction> findAllByFinancialAccountId(Long financialAccountId);
}
