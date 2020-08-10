package com.wisely.highlight_spring4.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xjq
 * @date 2020/7/27
 */
@Service
public class UseFunctionService {
    @Autowired
    FunctionService functionService;
    public String sayhello(String word){
        return functionService.sayhello(word);
    }

}
