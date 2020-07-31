package com.anxin.springcloud.service.impl;

import com.anxin.springcloud.dao.PaymentMapper;
import com.anxin.springcloud.pojo.Payment;
import com.anxin.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZC
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectById(id);
    }
}
