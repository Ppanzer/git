package com.wisely.highlight_spring4.ch3.conditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
/**
 * @author xjq
 * @date 2020/7/29
 */
@Configuration
public class ConditionConifg {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService WindowsListService(){
        return new WindowsListService();
    }
    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService();
    }
}
