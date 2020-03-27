package com.java.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangzhen
 * @create 2020-03-22 13:10
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/buy")
    public String buy(String name) {
        String s = restTemplate.getForObject("http://PROVIDER/ticket", String.class);
        return name + "买了" + s;
    }
}
