package com.anxin.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author ZC
 */
@Configuration
public class FeignConfig {

    @Bean
     Logger.Level feignLoggerLevel() {
         return Logger.Level.FULL;
     }
}
