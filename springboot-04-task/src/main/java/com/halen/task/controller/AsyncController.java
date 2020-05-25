package com.halen.task.controller;

import com.halen.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Halen 2020/5/25 9:13
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "success";
    }

}
