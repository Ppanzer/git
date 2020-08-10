package com.example.demo.mapper;

import com.example.demo.entity.Message;
import org.springframework.stereotype.Component;
/**
 * @author xjq
 * @date 2020/8/4
 */
@Component("MessageMapper")
public interface MessageMapper {
    int insertinfo(Message message);

    int updateinfo(Message message);

    Message selectinfo(String string);




}
