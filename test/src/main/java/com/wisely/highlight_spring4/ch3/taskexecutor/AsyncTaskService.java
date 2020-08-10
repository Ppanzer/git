package com.wisely.highlight_spring4.ch3.taskexecutor;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;
/**
 * @author xjq
 * @date 2020/7/29
 */
@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务: "+i);
    }
    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1: "+(i+1));
    }
}
