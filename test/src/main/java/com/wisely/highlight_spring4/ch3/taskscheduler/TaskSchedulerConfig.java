package com.wisely.highlight_spring4.ch3.taskscheduler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author xjq
 * @date 2020/7/29
 */
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch3.taskscheduler")
@EnableScheduling //1
public class TaskSchedulerConfig {
}
