package com.anxin.springcloud.service;

import com.anxin.springcloud.pojo.Payment;

/**
 * @author ZC
 */
public interface PaymentService {

 /*   int create(Payment payment);

    Payment getPaymentById(Long id);*/

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
}
