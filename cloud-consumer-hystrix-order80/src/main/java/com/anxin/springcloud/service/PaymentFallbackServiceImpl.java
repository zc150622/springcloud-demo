package com.anxin.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author ZC
 * @date 2020/8/1 4:10
 */
@Service
public class PaymentFallbackServiceImpl implements PaymentService{
    @Override
    public String timeout(Integer id) {
        return "feign: 服务超时或运行异常！timeout" ;
    }

    @Override
    public String ok(Integer id) {
        return "feign: 服务超时或运行异常！ok";
    }
}
