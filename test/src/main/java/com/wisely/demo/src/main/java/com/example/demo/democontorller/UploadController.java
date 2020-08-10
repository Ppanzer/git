package com.example.demo.democontorller;

import com.example.demo.demoservice.UploadService;
import com.example.demo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author xjq
 * @date 2020/8/4
 */
@Component
@RestController
@RequestMapping(value = "/commonfile", method = RequestMethod.POST)
public class UploadController {
    @Autowired
    UploadService uploadservice;

    @RequestMapping(value = "/upload")
    public String uploadMassage( @RequestParam(name = "username") String username,
                                  @RequestParam(name = "password") String password
                                  )throws Exception{
        Message message = new Message();
        message.setPassword(password);
        message.setUsername(username);
        if ( uploadservice.selectMessage(username)==null){
            this.uploadservice.addMessage(message);
            return "SignInSucceed";
        }
        else{
            this.uploadservice.updateMessage(message);
            return "ResetSucceed";
        }
    }

}
