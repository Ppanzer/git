package com.wisely.highlight_spring4.ch2.el;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * @author xjq
 * @date 2020/7/29
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ElConfig.class) ;
        ElConfig recourseService = context.getBean(ElConfig.class);
        recourseService.outputResource();
        context.close();
    }
}
