package com.shujuniu.user.mapper;

import com.shujuniu.user.po.userDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface userMapper {
    int insert(userDao record);

    int insertSelective(userDao record);
}