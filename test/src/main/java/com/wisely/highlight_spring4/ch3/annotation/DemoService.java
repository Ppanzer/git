package com.wisely.highlight_spring4.ch3.annotation;
import org.springframework.stereotype.Service;
/**
 * @author xjq
 * @date 2020/7/29
 */

@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置照样获得的bean");
    }
}
