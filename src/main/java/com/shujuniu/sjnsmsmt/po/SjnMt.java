package com.shujuniu.sjnsmsmt.po;

import lombok.Data;

import java.util.Date;
@Data
public class SjnMt {
    private Integer id;

    private String mobile;

    private String msgid;

    private String serviceid;

    private String srcid;

    private String msgsrc;

    private String destterminalid;

    private String msgcontent;

    private String sequenceid;

    private String status;

    private Date ctime;

    private Date rptime;


}