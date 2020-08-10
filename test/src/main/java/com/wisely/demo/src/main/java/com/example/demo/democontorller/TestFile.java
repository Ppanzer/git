package com.example.demo.democontorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xjq
 * @date 2020/8/4
 */
@Controller
@RequestMapping(value = "/testfile",produces = "application/json; charset=UTF-8")
public class TestFile {
    @RequestMapping(value = "/init")
//    @ResponseBody
    public String start() throws Exception {
        return "/upload.html";
    }
}