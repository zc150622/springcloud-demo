package com.anxin.springcloud.service;

import com.anxin.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZC
 */
public interface PaymentService {

    /**
     * hystrix
     * @param id /
     * @return /
     */
    String paymentInfoOk(Integer id);

    /**
     * 失败调用
     * @param id /
     * @return /
     */
    String paymentInfoTimeout(Integer id);


    /**
     * 服务熔断
     * @param id /
     * @return /
     */
    String paymentCircuitBreaker(Integer id);
}
