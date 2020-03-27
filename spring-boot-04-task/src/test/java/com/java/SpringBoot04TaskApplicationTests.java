package com.java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("开学了！！！！");
        message.setText("现今定于明日开学");

        message.setFrom("623717716@qq.com");
        message.setTo("huangzhencode@hnu.edu.cn");

        javaMailSender.send(message);
    }

    @Test
    void sendMimeMail() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        //true：表示允许发送附件
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setSubject("开学了！！！！");
        //true：表示 识别HTML代码
        helper.setText("<h1 style='color:red'>现今定于明日开学</h1>",true);

        helper.setFrom("623717716@qq.com");
        helper.setTo("huangzhencode@hnu.edu.cn");

        //添加附件
        helper.addAttachment("1.jpg", new File("D:\\chromeDownLoad\\picture\\picture01.jpg"));
        helper.addAttachment("2.jpg", new File("D:\\chromeDownLoad\\picture\\picture02.jpg"));

        javaMailSender.send(message);
    }



}
