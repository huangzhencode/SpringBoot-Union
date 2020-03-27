package com.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.java.mapper")
public class SpringBoot08MybatisplusCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08MybatisplusCrudApplication.class, args);
    }

}
