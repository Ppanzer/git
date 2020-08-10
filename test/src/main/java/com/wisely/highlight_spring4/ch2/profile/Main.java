package com.wisely.highlight_spring4.ch2.profile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * @author xjq
 * @date 2020/7/29
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProFileConfig.class);
        context.refresh();
        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }
}
