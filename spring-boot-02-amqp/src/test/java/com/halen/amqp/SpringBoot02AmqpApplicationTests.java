package com.halen.amqp;


import com.halen.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBoot02AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
        // 创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
        System.out.println("创建完成");
    }

    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        // message需要自己构造一个
        // rabbitTemplate.send(exchange, routeKey, message);

        // 只需要传入要发送的对象，自动序列化发送给RabbitMQ
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String, Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));
    }

    /**
     * 接收消息
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
    }

}
