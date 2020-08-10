package com.example.excalhandler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.example.excalhandler.entity.DataInsides;
import java.util.List;

/**
 * @author xjq
 * @date 2020/8/5
 */
@Mapper
@Component("ExcelhandlerMapper")
public interface ExcelhandlerMapper {
    /**
     * 批量插入数据
     * @param  dataList 输入数据列表；
     * @return  int
     */
    int insertinfo(List<DataInsides> dataList);
}
