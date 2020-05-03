package cn.hust.study.springboot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AcmeProperties.class) //
// @ConfigurationProperties 类可以不能被扫扫描到，在配置类中声明
public class MyConfiguartion {
}
