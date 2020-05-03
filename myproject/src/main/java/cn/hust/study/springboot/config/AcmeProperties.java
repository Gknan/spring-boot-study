package cn.hust.study.springboot.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ConfigurationProperties("acme")
@NoArgsConstructor // 无参构造
@AllArgsConstructor // 全参构造
@Data // lombok setter getter
public class AcmeProperties {

    private boolean enabled;

    private InetAddress remoteAddress;

    private final Security security = new Security();

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Security {

        private String username;

        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));


    }
}
