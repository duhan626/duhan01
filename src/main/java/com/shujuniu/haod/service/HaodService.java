package com.shujuniu.haod.service;


import com.shujuniu.haod.dto.HaodDTO;
import com.shujuniu.haod.po.Haod;

import java.util.List;

public interface HaodService {

String insert(HaodDTO record);


 String update(HaodDTO record);

    List<Haod> selectAll();

    String delete(Integer id);



}
