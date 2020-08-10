package com.wisely.highlight_spring4.ch2.prepost;

/**
 * @author xjq
 * @date 2020/7/29
 */
public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }
    public BeanWayService(){
        super();
        System.out.println("��ʼ�����캯��-BeanWayService");
    }
    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}
