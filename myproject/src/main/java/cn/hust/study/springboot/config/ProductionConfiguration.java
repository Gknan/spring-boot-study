package cn.hust.study.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration(proxyBeanMethods = false)
@Profile("production") // 限制该 bean 加载的时间
public class ProductionConfiguration {

    // ...

}