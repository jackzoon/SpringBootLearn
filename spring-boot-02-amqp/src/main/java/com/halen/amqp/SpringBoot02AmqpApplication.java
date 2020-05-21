package com.halen.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit //开启基于注解的RabbitMQ
public class SpringBoot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02AmqpApplication.class, args);
    }

}
