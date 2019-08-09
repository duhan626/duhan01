package com.shujuniu.gwbmid.controller;


import com.shujuniu.gwbmid.dto.GwbmidDto;
import com.shujuniu.gwbmid.service.GwBMIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 导出模版，上传模板，过滤重复
 */
@RestController
public class GwBMIDController {
    @Autowired
    protected GwBMIDService gwBMIDService;

    @GetMapping("/insertgwbmid")
    public String insertGwbmid() {
        gwBMIDService.insert();
        return "OK";
    }

    @GetMapping(value = "/selectgwbmid", produces = {"application/json;charset=UTF-8"})
    public Boolean selectGwbmid(@RequestBody GwbmidDto dto) {
        Boolean isok = false;
        try {
            isok = gwBMIDService.selectByMS(dto);
        } catch (Exception ex) {

        }
        return isok;
    }

    @GetMapping(value = "/dotxt")
    public int doTxt(HttpServletRequest request) {

        int i = 0;
        try {
            i = gwBMIDService.doTxt();
        } catch (Exception ex) {

        }
        return i;
    }

}
