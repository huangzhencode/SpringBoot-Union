package com.java.service;

import com.java.domain.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author huangzhen
 * @create 2020-03-21 13:09
 */
@Service
public class BookService {

    @RabbitListener(queues = {"huangzhen.news","xieya.news"})
    public void receive(Book book){
        System.out.println("book" + book);
    }
}
