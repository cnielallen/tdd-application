package com.cnielallen.tdd.event;

import com.cnielallen.tdd.data.FinancialTransactionDtoGenerator;

public class TestEvents {

    public static FinancialTransactionEvent getRandomFinancialTransactionEvent(){
        var eventMessage  = new FinancialTransactionEvent();
        eventMessage.setEventHeader(EventHeaderGenerator.randomEventHeader("FinancialTransaction"));
        eventMessage.setData(FinancialTransactionDtoGenerator.generateRandomFinancialTransactionDto());
        return eventMessage;
    }
}
