package com.dannycodes.test.controllers;

import com.dannycodes.test.common.TransactionRequest;
import com.dannycodes.test.common.TransactionResponse;
import com.dannycodes.test.entities.Order;
import com.dannycodes.test.services.OrderService;
import com.dannycodes.test.vo.Payment;
import com.dannycodes.test.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;


//    @PostMapping("/")
//    public TransactionResponse<?> saveOrder(@RequestBody TransactionRequest request){
//
//        return orderService.saveOrder(request);
//    }


    @PostMapping("/")
    public ResponseTemplateVo call (@RequestBody ResponseTemplateVo responseTemplateVo){

        return orderService.callPayments(responseTemplateVo);
    }


    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable int id){
        return orderService.getPayment(id);
    }

//    @GetMapping
//    public List<Payment> get(){
//        return orderService.getAll();
//    }

}
