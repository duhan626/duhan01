package com.shujuniu.user.controller;

import com.shujuniu.user.po.userDao;
import com.shujuniu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insert(userDao record){
        Object data = userService.insert(record);
        return "操作成功";
    }
}
