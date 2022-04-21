package com.dannycodes.test.common;


import com.dannycodes.test.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {



    private Order order;
    private Payment payment;

}
