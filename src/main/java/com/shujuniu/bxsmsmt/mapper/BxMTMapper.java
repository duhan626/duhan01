package com.shujuniu.bxsmsmt.mapper;

import com.shujuniu.bxsmsmt.po.BxMTDao;
import com.shujuniu.bxsmsmt.po.BxMTExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BxMTMapper {
    long countByExample(BxMTExample example);

    int deleteByExample(BxMTExample example);

    int insert(BxMTDao record);

    int insertSelective(BxMTDao record);

    List<BxMTDao> selectByExample(BxMTExample example);

    BxMTDao getMtDataList(String msgId);

    int updateByExampleSelective(BxMTDao record);

}