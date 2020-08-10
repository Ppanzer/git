package com.wisely.highlight_spring4.ch1.di;

import org.springframework.stereotype.Service;

/**
 * @author xjq
 * @date 2020/7/27
 */
@Service
public class FunctionService {
    public String sayhello(String word) {
        System.out.println("FunctionService");
        return "Hello"+" "+word;
    }
}
