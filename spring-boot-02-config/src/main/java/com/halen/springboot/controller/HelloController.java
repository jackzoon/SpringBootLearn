package com.halen.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Halen 2020/5/2 15:52
 */
@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello " + name;
    }

}
