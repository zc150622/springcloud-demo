package com.anxin.springcloud.controller;


import com.anxin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


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

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){

        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){

        return paymentService.paymentInfoTimeout(id);
    }


    @GetMapping("/payment/discovery")
    public Object discovery(){
        discoveryClient.getServices().forEach(log::info);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> log.info("**************" + instance.getHost() + "\t" + instance.getInstanceId() + "\t" + instance.getPort()));

        return discoveryClient;
    }
}
