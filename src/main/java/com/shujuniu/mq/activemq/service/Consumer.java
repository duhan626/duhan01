package com.shujuniu.mq.activemq.service;


import com.shujuniu.bxsmsmt.dto.BxMtDto;
import com.shujuniu.bxsmsmt.service.Impl.BxMtServiceImp;
import com.shujuniu.chinaunionopen.DTO.SmsmailDTO;
import com.shujuniu.chinaunionopen.mapper.NceMailAndSmsMapper;
import com.shujuniu.haod.service.HaodService;
import com.shujuniu.netty.cmppclient.CmppControler;
import com.shujuniu.sjnsmsmt.service.MtAddService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by LuoBin 2019/5/26 19:42
 */
@Slf4j
@Component
public class Consumer {
    private final HaodService haodService;
    private final MtAddService mtAddService;
    private final BxMtServiceImp bxMtServiceImp;
    private final NceMailAndSmsMapper nceMailAndSmsMapper;


    @Autowired
    public Consumer(HaodService haodService, MtAddService mtAddService, BxMtServiceImp bxMtServiceImp, NceMailAndSmsMapper nceMailAndSmsMapper) {
        this.haodService = haodService;
        this.mtAddService = mtAddService;
        this.bxMtServiceImp = bxMtServiceImp;
        this.nceMailAndSmsMapper = nceMailAndSmsMapper;
    }

    @JmsListener(destination = "sjnsms_submit_map")
    public void readMap(Map map) {
        CmppControler cmppControler = new CmppControler(haodService, mtAddService);
        String mobile = "";
        Integer writeLimit = 0;
        String userName = "";
        String password = "";
        String clientId = "";
        String ip = "";
        Integer port = 0;
        short maxChannels = 1;
        String content = "";
        String srcId = "";
        String serviceId = null;

        Set<String> keyset = map.keySet();
        for (String ks : keyset) {
            port = (Integer) map.get("port");
            ip = (String) map.get("ip");
            mobile = (String) map.get("mobile");
            writeLimit = (Integer) map.get("writeLimit");
            userName = (String) map.get("userName");
            password = (String) map.get("password");
            clientId = (String) map.get("clientId");
            maxChannels = (short) map.get("maxChannels");
            content = (String) map.get("content");
            serviceId = (String) map.get("serviceId");
            srcId = (String) map.get("srcId");
        }
        log.info("mobile:" + map.get("mobile"));
        log.info("writeLimit:" + map.get("writeLimit"));
        log.info("userName:" + map.get("userName"));
        cmppControler.cmppControler(ip, port, userName, mobile, password, clientId,
                maxChannels, writeLimit, content, srcId, serviceId);
    }

    @JmsListener(destination = "bxmtsubmittoucopen")
    public void bxmtsubmittoucopen(Map map) {
        String bid = null; //批次号
        Integer uid = null; //账户uid
        Integer gwid = null; //通道id
        String mb = null;//手机号
        Integer appid = null;
        String sc = null; //扩展号
        String p = null; //省份
        String c = null; //市
        Byte pt = 0;//信息数
        Byte pu = 0;//信息数
        Byte oper = 0;//运营商012
        String mid = null;//短信模板
        String emmid = null; //邮件模板
        String code = null; //验证码
        try {
            Set<String> keyset = map.keySet();
            for (String ks : keyset) {
                bid = (String) map.get("bid");
                uid = (Integer) map.get("uid");
                gwid = (Integer) map.get("gwid");
                mb = (String) map.get("mb");
                sc = (String) map.get("sc");
                p = (String) map.get("p");
                c = (String) map.get("c");
                pt = (Byte) map.get("pt");
                pu = (Byte) map.get("pu");
                oper = (Byte) map.get("oper");
                mid = (String) map.get("mid");
                emmid = (String) map.get("emmid");
                code = (String) map.get("code");
                appid = (Integer) map.get("appid");
            }

            BxMtDto bxMtDto = new BxMtDto();
            bxMtDto.setBid(bid);
            bxMtDto.setUid(uid);
            bxMtDto.setMb(mb);
            bxMtDto.setAppid(appid);
            bxMtDto.setC(c);
            bxMtDto.setP(p);
            bxMtDto.setSc(sc);
            bxMtDto.setPt((byte) pt);
            bxMtDto.setPu((byte) pu);
            bxMtDto.setOper((byte) oper);
            bxMtDto.setTemplatecode(mid);
            bxMtDto.setCode(code);
            bxMtDto.setGwid(gwid);
            bxMtDto.setCtime(new Date());
            bxMtDto.setMid(mid);
            bxMtDto.setEmmid(emmid);
//            bxMtDto.setRpttime(new Date("1900-01-01 00:00:00.000"));
            bxMtDto.setRpttime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).parse("1900-01-01 00:00:00.000"));
            log.info("提交MT给联通开放短邮AMQ出列:" + bxMtDto.toString());

            bxMtServiceImp.insetTMT(bxMtDto);
            log.info("AMQ出列成功！" + bxMtDto.toString());
        } catch (Exception ex) {
            System.out.println("提交MT给联通开放短邮AMQ出列:" + ex.getMessage());
            //显示异常，通道状设置为异常
            SmsmailDTO smsmailDTO = new SmsmailDTO();
            smsmailDTO.setGwId(gwid);
            smsmailDTO.setSt("AMQ出列异常" + ex.getMessage());
            nceMailAndSmsMapper.updateByGwidst(smsmailDTO);
        }

    }


}

