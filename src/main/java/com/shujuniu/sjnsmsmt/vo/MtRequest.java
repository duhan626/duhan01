package com.shujuniu.sjnsmsmt.vo;

import com.shujuniu.common.controller.BaseController;
import lombok.Data;

@Data
public class MtRequest extends BaseController {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }
}
