package com.cnielallen.tdd.data;

import com.cnielallen.tdd.model.FinancialTransactionDto;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.tyro.oss.randomdata.RandomBigDecimal.randomPositiveBigDecimal;
import static com.tyro.oss.randomdata.RandomLong.randomLong;
import static com.tyro.oss.randomdata.RandomString.randomAlphabeticString;

public class FinancialTransactionDtoGenerator {

    public static FinancialTransactionDto generateRandomFinancialTransactionDto() {
        return randomFinancialTransactionDtoBuilder().build();
    }

    public static FinancialTransactionDto.FinancialTransactionDtoBuilder randomFinancialTransactionDtoBuilder(){
        return FinancialTransactionDto.builder()
                .id(randomLong())
                .financialAccountId(randomLong())
                .accountType(randomAlphabeticString(2))
                .bankAccountNumber(randomLong())
                .transactionAmount(randomPositiveBigDecimal().setScale(2, RoundingMode.HALF_UP).stripTrailingZeros())
                .description(randomAlphabeticString(20))
                .emailAddress(randomAlphabeticString(20))
                .firstName(randomAlphabeticString(10))
                .lastName(randomAlphabeticString(10))
                .transactionDate(LocalDate.now());
    }

    public static List<FinancialTransactionDto> generateFinancialTransactionDto(int size){
        return IntStream.range(0, size)
                .mapToObj(value -> generateRandomFinancialTransactionDto())
                .collect(Collectors.toList());
    }
}
