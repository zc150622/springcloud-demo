package com.anxin.springcloud.controller;

import com.anxin.springcloud.entities.Result;

import com.anxin.springcloud.pojo.Payment;
import com.anxin.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.concurrent.TimeUnit;

/**
 * @author ZC
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderController {

    private final PaymentService paymentService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentService.ok(id);
    }


    public String timeout( Integer id){
        return paymentService.timeout(id);
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })

    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentService.timeout(id);
    }

    @GetMapping("/consumer/hystrix/default/timeout/{id}")
    @HystrixCommand
    public String defaultPayment(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentService.timeout(id);
    }

    public String paymentInfoTimeoutHandler(@PathVariable("id") Integer id) {
        return  "服务超时或运行出错！";
    }

    public String paymentGlobalFallback() {
        return "全局异常处理: 服务超时或运行出错！";
    }



}
