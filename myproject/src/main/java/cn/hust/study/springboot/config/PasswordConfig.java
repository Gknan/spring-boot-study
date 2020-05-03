package cn.hust.study.springboot.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordConfig {

    // 报错，绑定失败
    @Value("${spring.security.user.password}")
    private String passwd;
}
