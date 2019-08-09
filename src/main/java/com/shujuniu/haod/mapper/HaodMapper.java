package com.shujuniu.haod.mapper;

import com.shujuniu.haod.po.Haod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface HaodMapper {
    long countByExample(Haod example);

    int deleteByExample(Haod example);

    int insert(Haod record);

    int insertSelective(Haod record);

    List<Haod> selectByExample(Haod example);

    int updateByExampleSelective(@Param("record") Haod record, @Param("example") Haod example);

    int updateByExample(@Param("record") Haod record, @Param("example") Haod example);


    //修改
    int update(Haod haod);
    //查询
    List<Haod> selectAll();
    //删除
    int delete(Integer id);

}