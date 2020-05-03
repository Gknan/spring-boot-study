package cn.hust.study.springboot.controller;

import cn.hust.study.springboot.config.ListPropertiesConfig;
import cn.hust.study.springboot.config.PasswordConfig;
import cn.hust.study.springboot.entity.MyBean4;
import cn.hust.study.springboot.entity.MyBean5;
import cn.hust.study.springboot.service.impl.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Value("${app.description}")
    private String des;

    @GetMapping("/placeholader")
    public String testPalceHolder() {
        return des;
    }

    @Autowired
    private ListPropertiesConfig listPropertiesConfig;

    @GetMapping("/listPro")
    public String testListPro() {
        List<String> servers = listPropertiesConfig.getServers();
        StringBuilder stringBuilder = new StringBuilder();
        for (String string: servers) stringBuilder.append(string + " ");

        return stringBuilder.toString();
    }

//    @Autowired
//    private PasswordConfig passwordConfig;
//
//    @GetMapping("/getpwd")
//    public String getPasswd() {
//        return passwordConfig.getPasswd();
//    }


    @Autowired
    private MyService myService;

    @GetMapping("/opencon")
    public void openConnection() {
        myService.openConnection();
    }

}
