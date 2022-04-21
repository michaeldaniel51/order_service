package com.dannycodes.test.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {



    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private int amount;






}
