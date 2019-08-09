package com.shujuniu.common.rest;

////import io.swagger.annotations.ApiModelProperty;

import lombok.Data;


@Data
public abstract class BasePageListRequest {

//   //@ApiModelProperty(name = "pageSize" , value = "每页行数" , dataType = "java.lang.Integer")
    protected Integer pageSize;

//   //@ApiModelProperty(name = "pageNo" , value = "第几页" , dataType = "java.lang.Integer")
    protected Integer pageNo;

//   //@ApiModelProperty(name = "startIndex" , value = "查询辅助用，不必传" , dataType = "java.lang.Integer")
    private Integer startIndex; //偏移量初始记录行的偏移量是 0(而不是 1)

//    //列表权限 参数
//    private Integer userId;

    //列表权限 参数 角色id
    private Integer authRoleId;
    //列表权限 参数 企业id
    private Integer authCompanyId;
    //列表权限 参数 区域id
    private Integer authAreaId;
    //列表权限 参数 门店id
    private Integer authStoreId;
    //列表权限 参数 用户id
    private Integer authUserId;
}
