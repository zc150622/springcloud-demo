package com.anxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ZC
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakeServerApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurakeServerApplication7002.class,args);
    }
}
