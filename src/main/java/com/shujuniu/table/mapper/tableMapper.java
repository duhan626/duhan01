package com.shujuniu.table.mapper;

import com.shujuniu.table.po.table;

public interface tableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(table record);

    int insertSelective(table record);

    table selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(table record);

    int updateByPrimaryKey(table record);
}