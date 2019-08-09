package com.shujuniu.common.rest;


import lombok.Data;



@Data
public class AdminUserProfile {

    private Integer id;

    private String loginName;

    private String realName;

    //企业ID
    private Integer companyId;

    //门店ID
    private Integer storeId;

    //角色ID
    private Integer roleId;
    //区域ID
    private Integer areaId;
    //部门ID
    private Integer departmentId;
}
