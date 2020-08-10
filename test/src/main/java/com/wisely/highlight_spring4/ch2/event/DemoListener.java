package com.wisely.highlight_spring4.ch2.event;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * @author xjq
 * @date 2020/7/29
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {//2
        String msg = event.getMsg();
        System.out.println("��(bean-demoListener)���յ���bean-demoPublisher��������Ϣ:"+ msg);
    }
}
