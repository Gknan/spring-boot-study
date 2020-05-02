package cn.hust.study.springboot;

import cn.hust.study.springboot.config.CustomSpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@SpringBootApplication
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {

//        SpringApplication.run(Example.class, args);
//        CustomSpringApplication.run(Example.class, args);

        // 自定义 SpringApplication，实现关闭打印 Banner
        SpringApplication application = new SpringApplication(Example.class);
        application.setBannerMode(Banner.Mode.OFF);
//        WebApplicationType webApplicationType = application.getWebApplicationType();
//        System.out.println("实际使用的应用上下文类型：" + webApplicationType.getClass());
        application.run(args);

        // 链式编程 API
//        new SpringApplicationBuilder()
//                .sources(Example.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);


    }

}
