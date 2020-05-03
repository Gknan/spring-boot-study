package cn.hust.study.springboot.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AcmeProperties.class) //
// @ConfigurationProperties 类可以不能被扫扫描到，在配置类中声明
public class MyConfiguartion {

//    @Bean
//    public HttpMessageConverter customConverters() {
//
//        HttpMessageConverter<?> additional;
//        HttpMessageConverter<?> another;
//
//        return new HttpMessageConverters(additional, another);
//    }
}
