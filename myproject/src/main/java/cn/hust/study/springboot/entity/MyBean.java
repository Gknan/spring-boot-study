package cn.hust.study.springboot.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyBean {

    @Autowired
    public MyBean(ApplicationArguments arguments) {
        boolean debug = arguments.containsOption("debug");
        List<String> nonOptionArgs = arguments.getNonOptionArgs();
        System.out.println(nonOptionArgs);
        // 使用 --debug logfile.txt 参数运行  IDEA edit configurations -> Program
        // arguments
    }
}
