package com.wisely.highlight_spring4.ch1.aop;
import org.springframework.stereotype.Service;
/**
 * @author xjq
 * @date 2020/7/27
 */
@Service
public class DemoAnnotationService {
    @Action(name = "ע��ʽ���ص�ADD����")
    public void add(){ }
}
