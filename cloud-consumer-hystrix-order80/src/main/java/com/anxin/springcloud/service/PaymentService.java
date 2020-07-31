package com.anxin.springcloud.service;

import com.anxin.springcloud.entities.Result;
import com.anxin.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZC
 */
@Component
@FeignClient("CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentService {
    /**
     *  超时接口
     * @param id /
     * @return /
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
     String timeout(@PathVariable("id") Integer id);

    /**
     *  正常接口
     * @param id /
     * @return /
     */
    @GetMapping("/payment/hystrix/ok/{id}")
     String ok(@PathVariable("id") Integer id);
}
