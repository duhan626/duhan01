package com.shujuniu.chinaunionopen.service;

import com.shujuniu.chinaunionopen.DTO.SmsmailDTO;

public interface NceMailAndSmsService {

    SmsmailDTO sendNcEmailAndSmsTask(SmsmailDTO dto);

    int updateUcNotifystat(SmsmailDTO dto);

}
