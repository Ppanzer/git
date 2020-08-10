package com.example.excalhandler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xjq
 */
@SpringBootApplication
//@MapperScan("com.example.excalhandler.mapper.ExcelhandlerMapper")
public class ExcalhandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcalhandlerApplication.class, args);
    }

}
