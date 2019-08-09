package com.shujuniu.sjnsmsmt.service.impl;


import com.shujuniu.common.utils.NCarsBeanUtil;
import com.shujuniu.sjnsmsmt.dto.MtDTO;
import com.shujuniu.sjnsmsmt.mapper.SjnMtMapper;
import com.shujuniu.sjnsmsmt.po.SjnMt;
import com.shujuniu.sjnsmsmt.service.MtAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MtAddServiceipml implements MtAddService {
@Autowired
  private SjnMtMapper sjnsmsmtMapper;

    @Override
    public int insert(MtDTO dto) {
        SjnMt dao = NCarsBeanUtil.convertBean(dto, SjnMt.class);
        sjnsmsmtMapper.insert(dao);
        return 1;
    }

    @Override
    public int update(MtDTO data) {
        sjnsmsmtMapper.updateByPrimaryKeySelective(data);
        return 0;
    }
}
