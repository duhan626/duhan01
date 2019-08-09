package com.shujuniu.bxsmsmt.controller;

import com.shujuniu.bxsmsmt.dto.BxMtDto;
import com.shujuniu.bxsmsmt.service.BxMtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LuoBin 2019/6/30 16:05
 */
@Slf4j
@RestController
public class BxMtController {

//    @Value("${chinauionopen.clientIp}")
//    private String clientIp; //请求客户端IP
    @Autowired
    private BxMtService bxMtService;


    @RequestMapping("/bxmtsubmitadd")
    public String  BxMtSubmitAdd(BxMtDto dto, HttpServletRequest request) {
//        String remoteIp = null;
//        remoteIp = IPUtils.getRemoteHost(request);
//        if (!clientIp.contains(remoteIp)) {
//            return "请求失败！"+remoteIp;
//        }
        bxMtService.insetTMT(dto);
        return "OK";
    }


    @PostMapping(value = "/getToken", produces = {"application/json;charset=UTF-8"})
//    public String  androidgetToken(HttpServletRequest request) {
        public String  androidgetToken(@RequestBody BxMtDto dto){
        log.info("Token="+dto.getToken());
        System.out.println(dto.getToken());
        return dto.getToken();
    }
}
