package com.shujuniu.sjnsmsmt.service;


import com.shujuniu.sjnsmsmt.dto.MtDTO;



public interface MtAddService {
    int insert(MtDTO data);
    int update(MtDTO data);

}
