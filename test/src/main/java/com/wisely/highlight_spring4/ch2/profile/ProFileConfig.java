package com.wisely.highlight_spring4.ch2.profile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author xjq
 * @date 2020/7/29
 */
@Configuration
public class ProFileConfig {
    @Bean
    @Profile("dev")
    public DemoBean devBemoBean(){
        return new DemoBean("from development profile");
    }
    @Bean
    @Profile("prod")
    public DemoBean proDemoBean(){
        return new DemoBean("from production profile");
    }
}
