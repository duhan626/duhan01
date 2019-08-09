package com.shujuniu.tbidb.po;

import java.util.Date;

public class TBIDB {
    private Integer id;

    private String bid;

    private String dt;

    private Integer uid;

    private String ua;

    private String code;

    private Byte oper;

    private Integer gwid;

    private String msg;

    private String exc;

    private Short msglen;

    private Short mlen;

    private Short msgnum;

    private Integer mobnum;

    private Date ctime;

    private Integer num;

    private String mes;

    private Byte flag;

    private Date apptime;

    private Byte sendway;

    private Integer diu;

    private Byte xtype;

    private String doop;

    private String qm;

    private Integer appid;

    private String mb;

    private Byte ok;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt == null ? null : dt.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua == null ? null : ua.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Byte getOper() {
        return oper;
    }

    public void setOper(Byte oper) {
        this.oper = oper;
    }

    public Integer getGwid() {
        return gwid;
    }

    public void setGwid(Integer gwid) {
        this.gwid = gwid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getExc() {
        return exc;
    }

    public void setExc(String exc) {
        this.exc = exc == null ? null : exc.trim();
    }

    public Short getMsglen() {
        return msglen;
    }

    public void setMsglen(Short msglen) {
        this.msglen = msglen;
    }

    public Short getMlen() {
        return mlen;
    }

    public void setMlen(Short mlen) {
        this.mlen = mlen;
    }

    public Short getMsgnum() {
        return msgnum;
    }

    public void setMsgnum(Short msgnum) {
        this.msgnum = msgnum;
    }

    public Integer getMobnum() {
        return mobnum;
    }

    public void setMobnum(Integer mobnum) {
        this.mobnum = mobnum;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes == null ? null : mes.trim();
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public Date getApptime() {
        return apptime;
    }

    public void setApptime(Date apptime) {
        this.apptime = apptime;
    }

    public Byte getSendway() {
        return sendway;
    }

    public void setSendway(Byte sendway) {
        this.sendway = sendway;
    }

    public Integer getDiu() {
        return diu;
    }

    public void setDiu(Integer diu) {
        this.diu = diu;
    }

    public Byte getXtype() {
        return xtype;
    }

    public void setXtype(Byte xtype) {
        this.xtype = xtype;
    }

    public String getDoop() {
        return doop;
    }

    public void setDoop(String doop) {
        this.doop = doop == null ? null : doop.trim();
    }

    public String getQm() {
        return qm;
    }

    public void setQm(String qm) {
        this.qm = qm == null ? null : qm.trim();
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getMb() {
        return mb;
    }

    public void setMb(String mb) {
        this.mb = mb == null ? null : mb.trim();
    }

    public Byte getOk() {
        return ok;
    }

    public void setOk(Byte ok) {
        this.ok = ok;
    }
}