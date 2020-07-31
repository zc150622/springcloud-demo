package com.anxin.springcloud.controller;

import com.anxin.springcloud.entities.Result;
import com.anxin.springcloud.fegin.PaymentService;
import com.anxin.springcloud.pojo.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author ZC
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@SuppressWarnings("all")
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    private final RestTemplate restTemplate;
    private final PaymentService paymentService;

    @PostMapping("/consumer/create")
    public Result create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,Result.class);
    }

    @GetMapping("/consumer/get/{id}")
    public Result getPayment(@PathVariable("id") Long id){
        //return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,Result.class);
        return paymentService.getPayment(id);
    }

    @GetMapping("/consumer/fegin/time-out")
    public String timeOut(){
        //return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,Result.class);
        return paymentService.openFeignTimeOut();
    }
}
