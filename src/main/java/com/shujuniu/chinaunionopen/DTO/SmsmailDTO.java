package com.shujuniu.chinaunionopen.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class SmsmailDTO {
    private String taskId;
    private String sequenceId;
    private String channelId;
    private String taskTypeId;
    private Long recipient;
    private Long statusId;
    private String sendDate;
    private String errorCode;
    private String mobile;
    private String smsTemplateId;
    private String emailTemplateId;
    private String smsTemplateContext;
    private String emailTemplateContext;
    private String appid;
    private String smsTaskId;
    private String smsSequenceId;
    private String emailSequenceId;
    private String emailTaskId;
    private String partnerId;
    private String ip;
    private Integer gwtId;
    private Integer gwId;
    private String squenceId;
    private String srcId;
    private String status;
    private String destterminalId;
    private Date ctime;
    private Integer ret;
    private String st;
    private Date rpttime;

}
