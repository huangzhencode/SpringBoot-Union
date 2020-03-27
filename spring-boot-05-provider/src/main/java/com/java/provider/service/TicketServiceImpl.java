package com.java.provider.service;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author huangzhen
 * @create 2020-03-22 11:30
 */
@Service
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
