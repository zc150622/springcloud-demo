package com.anxin.springcloud.fegin;

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
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    /**
     *  测试feign
     * @param id /
     * @return /
     */
    @GetMapping("/payment/get/{id}")
    Result<Payment> getPayment(@PathVariable("id") Long id);

    /**
     *  ddd
     * @return /
     */
    @GetMapping("/payment/open/feign/timeOut")
    String openFeignTimeOut();
}
