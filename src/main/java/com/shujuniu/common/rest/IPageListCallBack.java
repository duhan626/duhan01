package com.shujuniu.common.rest;

import java.util.List;
import java.util.Map;

/**
 * Created by haiwei on 2018/8/8.
 */
public interface IPageListCallBack<T> {

    List<T> getPageDataList(Map<String, Object> pageListParamMap);

    Integer getPageTotalNum(Map<String, Object> pageListParamMap);
}
