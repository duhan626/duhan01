package com.shujuniu.gwbmid.service;


import com.shujuniu.gwbmid.dto.GwbmidDto;


public interface GwBMIDService {
    int insert();
    boolean selectByMS(GwbmidDto dto);
    int doTxt();
}
