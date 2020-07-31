package com.anxin.springcloud.controller;

import com.anxin.springcloud.entities.Result;

import com.anxin.springcloud.pojo.Payment;
import com.anxin.springcloud.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZC
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final PaymentService paymentService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentService.ok(id);
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        return paymentService.timeout(id);
    }
}
