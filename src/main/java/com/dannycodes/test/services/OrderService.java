package com.dannycodes.test.services;

import com.dannycodes.test.common.TransactionRequest;
import com.dannycodes.test.common.TransactionResponse;
import com.dannycodes.test.entities.Order;
import com.dannycodes.test.repositories.OrderRepository;
import com.dannycodes.test.vo.Payment;
import com.dannycodes.test.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

        public TransactionResponse<?> saveOrder(TransactionRequest request){

            String response="";

            Order order = request.getOrder();
            com.dannycodes.test.common.Payment payment = request.getPayment();
            payment.setOrderId(order.getId());
            payment.setAmount(order.getPrice());

           com.dannycodes.test.common.Payment paymentResponse = restTemplate.postForObject("http://localhost:8050/payment/doPayment",payment, com.dannycodes.test.common.Payment.class);

           response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is a failure in payment api, order added to cart";

           orderRepository.save(order);
            return new TransactionResponse<>(order, paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
        }



        public ResponseTemplateVo callPayments(ResponseTemplateVo responseTemplateVo){


            Order order = responseTemplateVo.getOrder();
            Payment payment = responseTemplateVo.getPayment();
            payment.setOrderId(order.getId());
            payment.setAmount(order.getPrice());
            Payment payments = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment, Payment.class);


            ResponseTemplateVo responseTemplateVo1 = ResponseTemplateVo
                    .builder()
                    .message(ResponseTemplateVo.paymentMessage())
                    .payment(payments)
                    .order(order)
                    .build();

//            responseTemplateVo.setOrder(order);
//            responseTemplateVo.setPayment(payments);

            orderRepository.save(order);
            return responseTemplateVo1;
        }

//        String url = "http://localhost:8050/payment/";

        public Payment getPayment(int id){

            Order order = orderRepository.getById(id);

            Payment payment = restTemplate.getForObject("http://PAYMENT-SERVICE/payment/" + order.getId(),Payment.class);

            return payment;
        }



//        public List<Payment> getAll(){
//
//            List<Payment> payment = (List<Payment>) restTemplate.getForObject("http://localhost:8050/payment/",Payment.class);
//            return payment;
//
//        }


}
