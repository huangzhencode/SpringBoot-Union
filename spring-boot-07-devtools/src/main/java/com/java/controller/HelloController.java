package com.java.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzhen
 * @create 2020-03-22 13:57
 */
@RestController
public class HelloController {

    @GetMapping("/hello/dd")
    public String hello(){
        return "hello";
    }
}
