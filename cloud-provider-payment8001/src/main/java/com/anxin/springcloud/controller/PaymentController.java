package com.anxin.springcloud.controller;

import com.anxin.springcloud.entities.Result;
import com.anxin.springcloud.pojo.Payment;
import com.anxin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Service;
import java.util.List;
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

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        discoveryClient.getServices().forEach(log::info);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> log.info("**************" + instance.getHost() + "\t" + instance.getInstanceId() + "\t" + instance.getPort()));

        return discoveryClient;
    }
}
