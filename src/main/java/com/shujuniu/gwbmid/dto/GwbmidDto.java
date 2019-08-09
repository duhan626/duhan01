package com.shujuniu.gwbmid.dto;

import lombok.Data;

import java.util.Date;
@Data
public class GwbmidDto {
    private Integer id;

    private String mid;

    private String ms;

    private Integer gwid;

    private Date cretime;

    private Date lasttime;

    private String operator;

    private String newms;

    private Byte flag;

    private String qm;
}
