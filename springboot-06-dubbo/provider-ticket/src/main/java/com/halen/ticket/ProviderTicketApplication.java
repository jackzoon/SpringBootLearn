package com.halen.ticket;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@DubboComponentScan
public class ProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApplication.class, args);
    }

}
