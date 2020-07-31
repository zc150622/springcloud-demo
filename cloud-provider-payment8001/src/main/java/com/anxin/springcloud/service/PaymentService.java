package com.anxin.springcloud.service;

import com.anxin.springcloud.pojo.Payment;

/**
 * @author ZC
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
