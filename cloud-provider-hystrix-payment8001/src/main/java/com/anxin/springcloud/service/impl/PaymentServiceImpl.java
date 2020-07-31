package com.anxin.springcloud.service.impl;

import com.anxin.springcloud.dao.PaymentMapper;
import com.anxin.springcloud.pojo.Payment;
import com.anxin.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ZC
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：" +Thread.currentThread().getName() + " paymentInfoOk: " + id + "\t" + "O(∩_∩)O哈哈~";
    }


    @Override
    public String paymentInfoTimeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" +Thread.currentThread().getName() + " paymentInfoTimeout: " + id + "\t" + "o(╥﹏╥)o";
    }
}
