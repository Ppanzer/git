package com.example.demo.demoservice;
import com.example.demo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.mapper.MessageMapper;

/**
 * @author xjq
 * @date 2020/8/4
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UploadService {
    @Autowired
    MessageMapper messagemapper;
    public boolean addMessage(Message message)throws Exception{
        return this.messagemapper.insertinfo(message) > 0;
    }
    public Message selectMessage(String target)throws Exception{
        return this.messagemapper.selectinfo(target);
    }
    public boolean updateMessage(Message message)throws Exception{
        return this.messagemapper.updateinfo(message) > 0;
    }
}
