package com.java.consumer;

import com.java.consumer.service.ConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot05ConsumerApplicationTests {

    @Autowired
    private ConsumerService consumerService;

    @Test
    void contextLoads() {
        consumerService.hello();
    }

}
