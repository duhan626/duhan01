package com.shujuniu.sjnsmsmt.controller;

import com.shujuniu.common.controller.BaseController;
import com.shujuniu.sjnsmsmt.dto.MtDTO;
import com.shujuniu.sjnsmsmt.service.MtAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mt")
public class mtCrontroller  extends BaseController {


    @Autowired
    private MtAddService mtAddService;
    @GetMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String doAdd(@RequestBody MtDTO dto) {
        try {
            Object data = mtAddService.insert(dto);
            return handlerObjectResult(data);
        } catch (Exception ex) {
            return handlerException(ex, "新增信息", dto);
        }
    }

}