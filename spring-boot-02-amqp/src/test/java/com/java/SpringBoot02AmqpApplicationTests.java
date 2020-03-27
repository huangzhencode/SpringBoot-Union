package com.java;

import com.java.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class SpringBoot02AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    private AmqpAdmin amqpAdmin;

    //单播  发送
    @Test
    void send() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("huangzhen", 23);
        map.put("xx", Arrays.asList("xieya", 22, true));
        rabbitTemplate.convertAndSend("huangzhen.direct", "huangzhen", map);
    }

    //接收
    @Test
    void receive(){
        Object o = rabbitTemplate.receiveAndConvert("huangzhen");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //广播
    @Test
    public void sendAll(){
        rabbitTemplate.convertAndSend("huangzhen.fnout", "", new Book("Spring技术内幕","小谢雅"));
    }

    //创建交换器和消息队列并绑定
    @Test
    public void exchange_queue(){
        //交换器
        amqpAdmin.declareExchange(new DirectExchange("ampqadmin.exchange"));
        //队列
        amqpAdmin.declareQueue(new Queue("ampqadmin.news", true));
        //绑定
        //destination: 队列名称  DestinationType：绑定的东西  exchange：交换机名称  routingKey：消息键  argument：参数
        amqpAdmin.declareBinding(new Binding("ampqadmin.news", Binding.DestinationType.QUEUE,"ampqadmin.exchange","ampq.hha",null));

    }

}
