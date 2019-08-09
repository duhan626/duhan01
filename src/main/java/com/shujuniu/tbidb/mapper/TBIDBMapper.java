package com.shujuniu.tbidb.mapper;

import com.shujuniu.tbidb.po.TBIDB;
import com.shujuniu.tbidb.po.TBIDBExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBIDBMapper {
    long countByExample(TBIDBExample example);

    int deleteByExample(TBIDBExample example);

    int insert(TBIDB record);

    int insertSelective(TBIDB record);

    List<TBIDB> selectByExample(TBIDBExample example);

    int updateByExampleSelective(@Param("record") TBIDB record, @Param("example") TBIDBExample example);

    int updateByExample(@Param("record") TBIDB record, @Param("example") TBIDBExample example);
}