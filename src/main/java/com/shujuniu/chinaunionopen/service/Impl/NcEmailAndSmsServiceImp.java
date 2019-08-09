package com.shujuniu.chinaunionopen.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.womail.openplatform.client.WoMailOPSDK;
import com.asiainfo.womail.openplatform.client.model.SendEmailAndSmsResponse;
import com.asiainfo.womail.openplatform.client.request.PushRequest;
import com.esotericsoftware.minlog.Log;
import com.shujuniu.bxsmsmt.mapper.BxMTMapper;
import com.shujuniu.bxsmsmt.po.BxMTDao;
import com.shujuniu.chinaunionopen.DTO.SmsmailDTO;
import com.shujuniu.chinaunionopen.mapper.NceMailAndSmsMapper;
import com.shujuniu.chinaunionopen.service.NceMailAndSmsService;
import com.shujuniu.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@Service
public class NcEmailAndSmsServiceImp implements NceMailAndSmsService {
    @Value("${chinauionopen.channelId}")
    private String channelId; //渠道标识
    @Value("${chinauionopen.channelSecret}")
    private String channelSecret; //渠道秘钥
    @Value("${chinauionopen.host}")
    private String host; //接口地址
    private int callretValue = 0;
    @Autowired
    private final BxMTMapper bxMTMapper;
    private final NceMailAndSmsMapper nceMailAndSmsMapper;


    public NcEmailAndSmsServiceImp(BxMTMapper bxMTMapper, NceMailAndSmsMapper nceMailAndSmsMapper) {
        this.bxMTMapper = bxMTMapper;
        this.nceMailAndSmsMapper = nceMailAndSmsMapper;

    }

    /**
     * 发送多副本邮短任务
     */
    @Override
    public SmsmailDTO sendNcEmailAndSmsTask(SmsmailDTO dto) {
        WoMailOPSDK sdk = new WoMailOPSDK(channelId, channelSecret, host);
//        List<Pair<File, String>> attachmentFiles = new ArrayList<>();
//        File file = FileUtil.findFile("D:\\myprj\\baseframe\\files\\10023923.pdf");
//        attachmentFiles.add(Pair.create(file, "10023923.pdf"));
        JSONObject SmsTemplateContext = new JSONObject();
        SmsTemplateContext.put("code", dto.getSmsTemplateContext());
        JSONObject EmailTemplateContext = new JSONObject();
        EmailTemplateContext.put("code", dto.getEmailTemplateContext());
        try {
            SendEmailAndSmsResponse tr = sdk.push().sendNcEmailAndSmsTask(new PushRequest.SendNcEmailAndSmsTask()
                            //应用 ID
                            .setAppId("o1bc6llalsgkvope4mimv1n98a")
                            //邮件模板 ID
                            .setEmailTemplateId(dto.getEmailTemplateId())
                            //短信模板 ID
                            .setSmsTemplateId(dto.getSmsTemplateId())
                            .setRecipient(dto.getMobile())
                            //{'占位符名字':'替换内容'}
                            .setSmsTemplateContext(SmsTemplateContext.toJSONString())
//                                .setSmsTemplateContext(dto.getSmsTemplateContext())
                            //邮件主题中包含占位符也在邮件正文中传值
                            //{'占位符名字':'替换内容'}
                            .setEmailTemplateContext(EmailTemplateContext.toJSONString())
//                                .setEmailTemplateContext("{dto.getEmailTemplateContext()")
                    //附件文件
//                                .setAttachmentFiles(attachmentFiles)
                    //群发文件，与接收人只能存在一个
//                        .setRecipientsFile(FileUtil.findFile("mdn.txt"))
            );
            log.info("setAppId=o1bc6llalsgkvope4mimv1n98a");
            log.info("setEmailTemplateId=" + dto.getEmailTemplateId());
            log.info("setSmsTemplateId=" + dto.getSmsTemplateId());
            log.info("setRecipient=" + dto.getMobile());
            log.info("setSmsTemplateContext=:" + SmsTemplateContext);
            log.info("setEmailTemplateContext:" + EmailTemplateContext);
            log.info("返回EmailSequenceId:" + tr.getEmailSequenceId());
            log.info("返回SmsSequenceId()" + tr.getSmsSequenceId());
            log.info("返回SmsSequenceId()" + tr.getSmsTaskId());
            log.info("返回EmailTaskId:" + tr.getEmailTaskId());
            log.info("返回PartnerId:" + tr.getPartnerId());
            dto.setTaskId(tr.getSmsTaskId());
            dto.setSmsSequenceId(tr.getSmsSequenceId());
            dto.setEmailTemplateId(tr.getEmailSequenceId());
            dto.setEmailTaskId(tr.getEmailTaskId());
            dto.setPartnerId(tr.getPartnerId());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.info("setAppId=o1bc6llalsgkvope4mimv1n98a");
            log.info("setEmailTemplateId=" + dto.getEmailTemplateId());
            log.info("setSmsTemplateId=" + dto.getSmsTemplateId());
            log.info("setRecipient=" + dto.getMobile());
            log.info("setSmsTemplateContext=:" + SmsTemplateContext.toJSONString());
            log.info("setEmailTemplateContext:" + EmailTemplateContext.toJSONString());
            log.info("调用sdk.push().sendNcEmailAndSmsTask（）返回：" + ex.getMessage());

        }
        return dto;
    }

    @Override
    public int updateUcNotifystat(SmsmailDTO dto) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        dto.setIp(IPUtils.getRemoteHost(request));
//        System.out.println(dto.getIp());
        BxMTDao bxMTDao = null;
        bxMTDao = bxMTMapper.getMtDataList(dto.getSequenceId());//从mt表取数据
        if(bxMTDao==null) {
             bxMTDao = new BxMTDao();
        }
            if (dto.getTaskTypeId().equalsIgnoreCase("SMS")) {
                Log.info("++++++++++++++++++++来自联通的状态通知updateUcNotifystat:" + dto.getSequenceId() + "  IP:" + dto.getIp());
                if (dto.getStatusId() == 5) { //发送成功状态
                    dto.setStatus("DELIVRD");
                    bxMTDao.setStat("DELIVRD");
                    bxMTDao.setOstat("DELIVRD");
                    dto.setSt("正常");
                    int isstatus = 0;
                    try {
                        isstatus = nceMailAndSmsMapper.updateByGwidst(dto); //更新通道表状态
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        Log.info("++++++++++++++++++++更新网关通道状态标识nceMailAndSmsMapper.updateByGwidst(dto)：" + isstatus);
                    }
                } else {
                    dto.setStatus(dto.getErrorCode());
                    bxMTDao.setStat(dto.getStatusId().toString());
                    bxMTDao.setOstat(dto.getErrorCode());
                }
                dto.setMobile(dto.getRecipient().toString());//手机号码
                dto.setGwId(bxMTDao.getGwid());//通道ID
                dto.setSrcId(bxMTDao.getSc());//扩展
                dto.setDestterminalId(bxMTDao.getDs());//
                dto.setRpttime(new Date());//状态时间

                dto.setGwtId(13); //字典设置数巨牛http，通道类型
                try {
                    callretValue = nceMailAndSmsMapper.updateByCRPTCall(dto);//调用存储过程写MT等
                } catch (Exception ex) {
                    Log.info("++++++++++++++++++++调用SQL Server存储过程返回值nceMailAndSmsMapper.updateByCRPTCall()：" + callretValue);
                }

                bxMTDao.setRpttime(new Date());
                bxMTDao.setMsgid(dto.getSequenceId());
//            bxMTMapper.updateByExampleSelective(bxMTDao);
            }

        return callretValue;
    }


}
