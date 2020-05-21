package com.halen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created By Halen 2020/5/8 21:53
 */
@Controller
public class HelloController {

    @GetMapping("/abc")
    public String hello(Model model) {
        model.addAttribute("msg", "你好");
        return "success";
    }
}
