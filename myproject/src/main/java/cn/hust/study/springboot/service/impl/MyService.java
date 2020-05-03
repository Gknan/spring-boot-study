package cn.hust.study.springboot.service.impl;

import cn.hust.study.springboot.config.AcmeProperties;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class MyService {

    @Autowired
    private final AcmeProperties acmeProperties;

    public MyService(AcmeProperties acmeProperties) {
        this.acmeProperties = acmeProperties;
    }

    // 构造函数完成后执行
    @PostConstruct
    public void openConnection() {
//        Server server = new Server(this.acmeProperties.getRemoteAddress());
        log.info("Get Remote Address from ConfiguraionProperties: {}, Securiy" +
                        " username: {}",
                this.acmeProperties.getRemoteAddress(),
                JSON.toJSONString(this.acmeProperties));
        // ...
    }
}
