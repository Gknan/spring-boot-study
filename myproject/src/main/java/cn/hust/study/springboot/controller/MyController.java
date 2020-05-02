package cn.hust.study.springboot.controller;

import cn.hust.study.springboot.entity.MyBean4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyBean4 myBean4;

    @GetMapping("/hello")
    public String hello() {
        return "hello hhh";
    }

    @GetMapping("/mybean4")
    public String testMyBean4() {
        return myBean4.getName();
    }

}
