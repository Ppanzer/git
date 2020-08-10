package com.example.excalhandler.entity;
import com.example.excalhandler.entity.DataInsides;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjq
 * @date 2020/8/5
 */
public class DataList {
    private List<DataInsides> datalist = new ArrayList<>();

    public List<DataInsides> getDatalist() {
        return datalist;
    }

    public void setDatalist(DataInsides dataInsides) {
        datalist.add(dataInsides);
    }
}
