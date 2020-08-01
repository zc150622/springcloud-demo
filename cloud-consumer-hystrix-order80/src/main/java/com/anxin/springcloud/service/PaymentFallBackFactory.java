package com.anxin.springcloud.service;

import feign.hystrix.FallbackFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ZC
 * @date 2020/8/1 4:57
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentFallBackFactory implements FallbackFactory<PaymentService> {

    private final ApplicationContext applicationContext;

    @Override
    public PaymentService create(Throwable throwable) {
         log.error(throwable.getMessage());
         return new PaymentFallbackServiceImpl();
    }

    //也可以通过匿名内部类的方式重写接口里的所有方法
}
