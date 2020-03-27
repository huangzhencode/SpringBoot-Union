package com.java.provider.controller;

import com.java.provider.service.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzhen
 * @create 2020-03-22 13:00
 */
@RestController
public class TicketController {

    @Autowired
    private TickerService service;

    @GetMapping("/ticket")
    public String ticket(){
        return service.ticket();
    }
}
