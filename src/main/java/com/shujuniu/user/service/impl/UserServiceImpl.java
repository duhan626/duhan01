package com.shujuniu.user.service.impl;

import com.shujuniu.user.mapper.userMapper;
import com.shujuniu.user.po.userDao;
import com.shujuniu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private userMapper userMapper;
    public int insert(userDao record){
        return userMapper.insert(record);
    }
}
