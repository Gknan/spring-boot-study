package cn.hust.study.springboot.service.impl;

import cn.hust.study.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseAccountService implements AccountService {

    private final RiskAssessor riskAssessor;

//    @Autowired // 如果只有一个构造函数，@Autowired 直接可以省略
    public DatabaseAccountService(RiskAssessor riskAssessor) {
        this.riskAssessor = riskAssessor;
    }
}
