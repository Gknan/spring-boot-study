package cn.hust.study.springboot.config;


import cn.hust.study.springboot.entity.MyPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.InetAddress;
import java.util.*;

@ConfigurationProperties("acme")
@NoArgsConstructor // 无参构造
@AllArgsConstructor // 全参构造
@Data // lombok setter getter
@Validated // 校验
public class AcmeProperties {

    private boolean enabled;

    @NotNull // 校验非空 若为空，则报错
    private InetAddress remoteAddress;

    @Valid
    private final Security security = new Security();

    private final List<MyPojo> list = new ArrayList<>();

    private final Map<String, MyPojo> map = new HashMap<>();

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Security {

        @NotEmpty // 校验非空
        private String username;

        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));


    }
}
