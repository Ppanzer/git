package com.wisely.highlight_spring4.ch2.profile;

/**
 * @author xjq
 * @date 2020/7/29
 */
public class DemoBean {
    private String content;
    public DemoBean(String content){
        super();
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
