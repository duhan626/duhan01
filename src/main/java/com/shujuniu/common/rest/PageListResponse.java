package com.shujuniu.common.rest;

import lombok.Data;

import java.util.List;
@Data
public class PageListResponse<T> {

    private Integer totalNum;      //总记录数
    private Integer totalPage;     //总页数

    private List<T> dataList;      //当前页数据

    public PageListResponse(){

    }

    public PageListResponse(Integer totalNum, Integer totalPage, List<T> dataList) {
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        this.dataList = dataList;
    }

}
