package com.example.excalhandler.service;

import com.example.excalhandler.mapper.ExcelhandlerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.excalhandler.entity.DataInsides;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xjq
 * @date 2020/8/5
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EHService {

    @Resource
    ExcelhandlerMapper excelhandlerMapper;

    public boolean uploadfile(List<DataInsides> dataList)throws Exception{
        return this.excelhandlerMapper.insertinfo(dataList) > 0;
    }
}
