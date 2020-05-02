package cn.hust.study.springboot.controller;

import cn.hust.study.springboot.entity.MyBean4;
import cn.hust.study.springboot.entity.MyBean5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyBean4 myBean4;


    private final MyBean5 myBean5;

    @Autowired
    public MyController(MyBean4 myBean4, MyBean5 myBean5) {
        this.myBean4 = myBean4;
        this.myBean5 = myBean5;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello hhh";
    }

    @GetMapping("/mybean4")
    public String testMyBean4() {
        return myBean4.getName();
    }

    @GetMapping("/mybean5")
    public String testMyBean5() {
        return myBean5.toString();
    }

}
