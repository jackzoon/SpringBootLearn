package com.halen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created By Halen 2020/5/1 18:22
 * @SpringBootApplication 来标注个主程序类，说明这是一个SpringBoot应用
 */
@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        // Spring应用启动起来
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
