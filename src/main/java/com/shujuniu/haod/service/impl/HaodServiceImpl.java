package com.shujuniu.haod.service.impl;

import com.shujuniu.common.utils.NCarsBeanUtil;
import com.shujuniu.haod.dto.HaodDTO;
import com.shujuniu.haod.mapper.HaodMapper;
import com.shujuniu.haod.po.Haod;
import com.shujuniu.haod.service.HaodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HaodServiceImpl implements HaodService {
    @Autowired
    private HaodMapper haodMapper;


 @Override
    public String insert(HaodDTO dto) {
        Haod haod = NCarsBeanUtil.convertBean(dto, Haod.class);
        haodMapper.insert(haod);
//        Integer id = haod.getUserId();
        return "1";
    }


@Override
    public String update(HaodDTO record) {
        Haod haod = NCarsBeanUtil.convertBean(record, Haod.class);
        int result = haodMapper.update(haod);
        return "ok";
    }

    @Override
    public List<Haod> selectAll() {
        return haodMapper.selectAll();
    }

    @Override
    public String delete(Integer id) {
        haodMapper.delete(id);
        return "ok";
    }


    public String addMt(HaodDTO dto) {
        Haod haod = NCarsBeanUtil.convertBean(dto, Haod.class);
        haodMapper.insert(haod);
        return "2";
    }

}
