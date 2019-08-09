package com.shujuniu.haod.controller;

import com.shujuniu.common.controller.BaseController;
import com.shujuniu.haod.dto.HaodDTO;
import com.shujuniu.haod.po.Haod;
import com.shujuniu.haod.service.HaodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/haod")
public class HaodCrontroller extends BaseController {

@Autowired
    private HaodService haodService;
    @GetMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String doAdd(@RequestBody HaodDTO dto) {
        try {
            Object data = haodService.insert(dto);
            System.out.println("===============================success!");
            return handlerObjectResult(data);
        } catch (Exception ex) {
            System.out.println("=================error");
            return handlerException(ex, "新增信息", dto);
        }
    }


@GetMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public String doUpdate(@RequestBody HaodDTO dto) {
        try {
            return haodService.update(dto);
        } catch (Exception ex) {
            return "error!";
        }
    }
    @GetMapping(value = "/delete")
    public String doDelete(@RequestBody Integer id) {
        try {
            return haodService.delete(id);
        } catch (Exception ex) {
            System.out.println("=================error");
            return "error!";
        }
    }
    @GetMapping(value = "/selectAll")
    public List<Haod> doSelectAll() {
        try {
            return haodService.selectAll();
        } catch (Exception ex) {
            return null;
        }
    }



}
