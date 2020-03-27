package com.java;

import com.java.domain.Employee;
import com.java.mapper.EmployeeMapper;
import com.java.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.Serializable;

@SpringBootTest
class SpringBoot01CacheApplicationTests {


    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Autowired
    private RedisTemplate redisTemplate;



    @Test
    void contextLoads() {
//        stringRedisTemplate.opsForValue().append("huangzhen", "300000");

        Employee employee = employeeMapper.findEmpByid(3);
        redisTemplate.opsForValue().set("emp13",employee);
    }





}
