package com.shujuniu.sjnsmsmt.mapper;

import com.shujuniu.sjnsmsmt.dto.MtDTO;
import com.shujuniu.sjnsmsmt.po.SjnMt;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SjnMtMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SjnMt record);

    int insertSelective(SjnMt record);

    SjnMt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MtDTO record);

    int updateByPrimaryKey(SjnMt record);
}