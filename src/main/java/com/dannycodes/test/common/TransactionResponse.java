package com.dannycodes.test.common;

import com.dannycodes.test.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse <T> {

    private T order;
    private double amount;
    private String transactionId;
    private String message;




}
