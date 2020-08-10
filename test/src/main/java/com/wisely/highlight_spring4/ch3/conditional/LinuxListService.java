package com.wisely.highlight_spring4.ch3.conditional;

/**
 * @author xjq
 * @date 2020/7/29
 */
public class LinuxListService implements ListService{
    @Override
    public String showListCmd() {
        return "ls";
    }
}
