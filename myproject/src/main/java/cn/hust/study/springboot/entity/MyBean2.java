package cn.hust.study.springboot.entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(value = 1)
public class MyBean2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyBean2 CommandLineRunner run");
    }
}
