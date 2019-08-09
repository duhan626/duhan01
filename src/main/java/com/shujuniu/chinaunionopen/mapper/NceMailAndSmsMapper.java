package com.shujuniu.chinaunionopen.mapper;

import com.shujuniu.chinaunionopen.DTO.SmsmailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface NceMailAndSmsMapper {

    int updateByCRPTCall(SmsmailDTO dto);
    int updateByGwidst(SmsmailDTO dto);
}
