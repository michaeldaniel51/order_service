package com.dannycodes.test.vo;


import com.dannycodes.test.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTemplateVo {


    private Order order;
    private Payment payment;
    private String message;



    public static String paymentMessage() {
        return new Random()
                .nextBoolean()?
                MessageResponse.ACCEPTED.toString() :
                MessageResponse.SUCCESSFUL.toString();
    }

}
