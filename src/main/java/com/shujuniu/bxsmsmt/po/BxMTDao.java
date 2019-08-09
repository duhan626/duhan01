package com.shujuniu.bxsmsmt.po;

import lombok.Data;

import java.util.Date;

@Data
public class BxMTDao {
    private Integer id;

    private String bid;

    private Integer uid;

    private String msgid;

    private Integer gwid;

    private String mb;

    private Date ctime;

    private String ret;

    private String stat;

    private String oret;

    private String ostat;

    private String ds;

    private Date rpttime;

    private String sc;

    private String p;

    private String c;

    private Byte pt;

    private Byte pu;

    private Integer appid;

    private Byte oper;

    private String gwst;

}