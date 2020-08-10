package com.example.demo.entity;
/**
 * @author xjq
 * @date 2020/8/4
 */
public class Message {

    private Integer UID;

    private String username;

    private String password;

    public Integer getUID(){return UID;}

    public void setUID(Integer UID){this.UID = UID ;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getUsername(){return username;}

    public void setUsername(String username) {this.username = username; }
}
