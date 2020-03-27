package com.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.java.mapper")
@EnableCaching //开启缓存
public class SpringBoot01CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01CacheApplication.class, args);
    }
}
