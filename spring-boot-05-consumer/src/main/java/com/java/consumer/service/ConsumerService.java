package com.java.consumer.service;

import com.java.provider.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {

    @Reference
    TicketService ticketService;

    public void hello(){
        System.out.println("买到票 ： " + ticketService.getTicket());
    }
}
