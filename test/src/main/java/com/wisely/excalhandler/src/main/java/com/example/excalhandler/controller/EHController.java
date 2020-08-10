package com.example.excalhandler.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.excalhandler.entity.DataInsides;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.excalhandler.service.EHService;
import com.example.excalhandler.util.FileUtil;
import com.example.excalhandler.util.ExcelReader;



/**
 * @author xjq
 * @date 2020/8/5
 */
@Component
@RestController
@RequestMapping(value = "/commonfile", method = RequestMethod.POST)
public class EHController {
    @Autowired
    EHService ehService;

    @Value("${common.file.base.path}")
    private String fileBaseSavePath;

    @RequestMapping(value ="/upload",produces = "application/json; charset=UTF-8")
    public String upload(@RequestPart(name = "file") MultipartFile multipartFile)throws Exception {

        String filePath = "";
        String fileRealName  = multipartFile.getOriginalFilename();

        String fileSaveDir = fileBaseSavePath +"/";
        // 如果文件夹不存在，创建
        FileUtil.confirmFolderExists(fileSaveDir);
        FileUtil.saveFile(multipartFile.getInputStream(), fileSaveDir, fileRealName );

        multipartFile.getInputStream().close();
        filePath =fileSaveDir+ fileRealName ;
        List<DataInsides> readResult = ExcelReader.readExcel(filePath);

        List<DataInsides> readResultPart=new ArrayList<>();
        int count = 0;
        for(DataInsides part: Objects.requireNonNull(readResult)){
           readResultPart.add(part);
           count += 1;
           if(count == 100){
               this.ehService.uploadfile(readResultPart);
               count = 0;
               readResultPart.clear();
           }
        }
        if(!readResultPart.isEmpty()) {
            this.ehService.uploadfile(readResultPart);
        }

        return "Finished";
    }


}
