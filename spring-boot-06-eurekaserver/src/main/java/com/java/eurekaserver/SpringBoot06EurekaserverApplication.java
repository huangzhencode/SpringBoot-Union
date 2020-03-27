package com.java.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBoot06EurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06EurekaserverApplication.class, args);
    }

}
