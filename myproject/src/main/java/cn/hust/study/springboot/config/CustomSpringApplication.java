package cn.hust.study.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CustomSpringApplication extends SpringApplication {

    @Override
    protected void logStartupInfo(boolean isRoot) {
        super.logStartupInfo(isRoot);
        System.out.println("************* custom infos *************");
    }
}
