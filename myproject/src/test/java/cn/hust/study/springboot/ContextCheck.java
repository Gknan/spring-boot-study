package cn.hust.study.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ContextCheck {

    @Test
    public void context() {
        System.out.println("health context");
    }
}
