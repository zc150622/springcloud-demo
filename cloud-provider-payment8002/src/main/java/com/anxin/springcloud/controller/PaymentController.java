package com.anxin.springcloud.controller;

import com.anxin.springcloud.entities.Result;
import com.anxin.springcloud.pojo.Payment;
import com.anxin.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author ZC
 */

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public Result create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("=========返回结果：" + i +"......");

        if (i > 0){
            return new Result(200,"success" + serverPort);
        }else {
            return new Result(500,"支付失败" + serverPort);
        }
    }
    @GetMapping("/payment/get/{id}")
    public Result<Payment> getPayment(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("========查询结果：" + payment);
        if (payment != null){
            return new Result<>(200,"success" + serverPort,payment);
        }else {
            return new Result<>(404,"没有对应信息" + serverPort);
        }
    }

    @GetMapping("/payment/open/feign/timeOut")
    public String  openFeignTimeOut()  {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
