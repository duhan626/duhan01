package com.shujuniu.gwbmid.mapper;

import com.shujuniu.gwbmid.po.GwBMIDDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GwBMIDMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GwBMIDDao record);

    int insertSelective(GwBMIDDao record);

    GwBMIDDao selectByPrimaryKey(Integer id);

    GwBMIDDao selectByMS(String  ms);

    int updateByPrimaryKeySelective(GwBMIDDao record);

    int updateByPrimaryKey(GwBMIDDao record);
}