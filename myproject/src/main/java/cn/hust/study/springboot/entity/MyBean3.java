package cn.hust.study.springboot.entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 演示多个 CommandLineRunner 的执行顺序控制
 * 使用 @Order 注解
 */
//@Component
@Order(value = 2)
public class MyBean3 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyBean3 CommandLineRunner run");
    }
}
