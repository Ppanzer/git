package com.wisely.highlight_spring4.ch1.di;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * @author xjq
 * @date 2020/7/27
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Diconfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayhello("xingjiaqi"));
        context.close();
    }
}
