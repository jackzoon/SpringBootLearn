package com.halen.amqp.service;

import com.halen.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created By Halen 2020/5/20 19:36
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
        System.out.println("收到消息:" + book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}
