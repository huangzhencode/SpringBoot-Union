package com.java.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.java.provider.service")
public class SpringBoot05ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot05ProviderApplication.class, args);
    }
}
