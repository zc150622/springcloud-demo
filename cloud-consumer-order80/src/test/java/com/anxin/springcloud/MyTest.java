package com.anxin.springcloud;

import com.anxin.springcloud.entities.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
public class MyTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void T1(){
        String s = restTemplate.getForObject("https://www.baidu.com/", String.class);

    }
}
