package com.wisely.highlight_spring4.ch3.taskscheduler;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/**
 * @author xjq
 * @date 2020/7/29
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat();
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
    }
    @Scheduled(cron = "0 44 16 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间"+dateFormat.format(new Date())+"执行");
    }
}
