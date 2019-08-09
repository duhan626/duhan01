package com.shujuniu.bxsmsmt.service.Impl;

import com.shujuniu.bxsmsmt.dto.BxMtDto;
import com.shujuniu.bxsmsmt.mapper.BxMTMapper;
import com.shujuniu.bxsmsmt.po.BxMTDao;
import com.shujuniu.bxsmsmt.service.BxMtService;
import com.shujuniu.chinaunionopen.DTO.SmsmailDTO;
import com.shujuniu.chinaunionopen.mapper.NceMailAndSmsMapper;
import com.shujuniu.chinaunionopen.service.NceMailAndSmsService;
import com.shujuniu.common.utils.NCarsBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by LuoBin 2019/6/30 15:54
 */
@Slf4j
@Service
public class BxMtServiceImp implements BxMtService {
    @Autowired
    private final BxMTMapper bxMTMapper;
    private final NceMailAndSmsMapper nceMailAndSmsMapper;
    @Autowired
    private final NceMailAndSmsService nceMailAndSmsService;

    public BxMtServiceImp(BxMTMapper bxMTMapper, NceMailAndSmsMapper nceMailAndSmsMapper, NceMailAndSmsService nceMailAndSmsService) {
        this.bxMTMapper = bxMTMapper;
        this.nceMailAndSmsMapper = nceMailAndSmsMapper;
        this.nceMailAndSmsService = nceMailAndSmsService;
    }

    @Override
    public String insetTMT(BxMtDto dto) {
        SmsmailDTO smsmailDTO = new SmsmailDTO();
        smsmailDTO.setEmailTemplateId(dto.getEmmid());
        smsmailDTO.setSmsTemplateContext(dto.getCode());
        smsmailDTO.setSmsTemplateId(dto.getMid());
        smsmailDTO.setMobile(dto.getMb());
        smsmailDTO.setEmailTemplateContext(dto.getCode());
        SmsmailDTO dto1 = null;
        int i = 0;
        try {
            boolean isChinese = (dto.getCode().length() == dto.getCode().getBytes().length);//true:无汉字  false:有汉字
            log.info("模版验证码：" + dto.getCode() + " 是否有中文isChinese:" + isChinese);
            if (isChinese) { //验证码不含中文才调用
                dto1 = nceMailAndSmsService.sendNcEmailAndSmsTask(smsmailDTO);
            }
//            System.out.println("+++++++++++++++++++++" + dto1.getMobile() + dto1.toString());

            if (dto1 == null || isChinese == false) { //联通通道模板审批失败等原因，直接失败
                dto.setMsgid(dto.getBid());
                dto.setOret("Error");
                dto.setRpttime(new Date());
                dto.setRet("0");
                dto.setStat("UNDELIV");
                dto.setOstat("UNDELIV");
                BxMTDao dao = NCarsBeanUtil.convertBean(dto, BxMTDao.class);
                i = bxMTMapper.insert(dao);
                if (i > 0) {
                    dto1.setSequenceId(dto.getBid());
                    dto1.setRecipient(Long.valueOf(dto.getMb()));
                    dto1.setTaskTypeId("SMS");
                    dto1.setStatusId(Long.valueOf(9));
                    nceMailAndSmsService.updateUcNotifystat(dto1);//失败调用存储过程通知客户失败原因
                }
            } else {
//                (dto1.getSmsSequenceId() != null) {
                    dto.setMsgid(dto1.getSmsSequenceId());
                    dto.setOret("0");
                    dto.setRet("0");
                    dto.setStat(" ");
                    dto.setOstat(" ");
                    dto.setDs("0");
                    BxMTDao dao = NCarsBeanUtil.convertBean(dto, BxMTDao.class);
                    i = bxMTMapper.insert(dao);
                }

            } catch(Exception ex){    //调用失败显示异常，通道状设置为异常
                smsmailDTO.setGwId(dto.getGwid());
                smsmailDTO.setSt("提交MT信息到联通短邮发送接口出现调用异常！" + ex.getMessage());
                nceMailAndSmsMapper.updateByGwidst(smsmailDTO);
                dto.setOret(ex.getMessage().substring(0, 25));
                dto.setRet("参数错误");
                dto.setStat("UNDELIV");
                dto.setOstat("UNDELIV");
                dto.setMsgid(dto.getBid());
                BxMTDao dao = NCarsBeanUtil.convertBean(dto, BxMTDao.class);
                i = bxMTMapper.insert(dao);
                if (i > 0) {
                    dto1.setSequenceId(dto.getBid());
                    dto1.setRecipient(Long.valueOf(dto.getMb().toString()));
                    dto1.setTaskTypeId("SMS");//短信类型
                    dto1.setStatusId(Long.valueOf(9));//状态
                    nceMailAndSmsService.updateUcNotifystat(dto1);//失败调用存储过程通知客户失败原因
                }
            }

            return String.valueOf(i);

        }

        @Override
        public boolean updateTMTBySubmit (BxMTDao dao){
            Boolean isstatus = false;
            int i = bxMTMapper.updateByExampleSelective(dao);
            if (i > 0) {
                isstatus = true;
            }
            return isstatus;
        }

        @Override
        public BxMTDao getMtDataList (String msgId){

            return bxMTMapper.getMtDataList(msgId);
        }
    }
