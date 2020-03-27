package com.java.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBoot06ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06ProviderApplication.class, args);
    }

}
