package com.shujuniu.chinaunionopen.controller;


import com.esotericsoftware.minlog.Log;
import com.shujuniu.chinaunionopen.DTO.SmsmailDTO;
import com.shujuniu.chinaunionopen.service.NceMailAndSmsService;
import com.shujuniu.common.controller.BaseController;
import com.shujuniu.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/smsAndmailopen")
public class SmsmailController extends BaseController {
    @Value("${chinauionopen.clientIp}")
    private String clientIp; //请求客户端IP
    @Autowired
    private NceMailAndSmsService nceMailAndSmsService;

    /**
     * 联通开放平台提交
     *
     * @param smsTemplateId
     * @param emailTemplateId
     * @param mobile
     * @param smsTemplateContext
     * @param emailTemplateContext
     * @return
     */
    @RequestMapping("bxsmsSubmittoUc")
    public String bxsmsSubmittoUc(String smsTemplateId, String emailTemplateId, String mobile, String smsTemplateContext, String emailTemplateContext, HttpServletRequest request) {
        String remoteIp = null;
        remoteIp = IPUtils.getRemoteHost(request);
        if (!clientIp.contains(remoteIp)) {
            return "请求失败！" + remoteIp;
        }
        SmsmailDTO dto = new SmsmailDTO();
        try {
            dto.setSmsTemplateId(smsTemplateId);
            dto.setEmailTemplateId(emailTemplateId);
            dto.setMobile(mobile);
            dto.setSmsTemplateContext(smsTemplateContext);
            dto.setEmailTemplateContext(emailTemplateContext);
            Object data = nceMailAndSmsService.sendNcEmailAndSmsTask(dto);
//            return handlerListResult(data, 0);
            return dto.getSmsSequenceId();//响应sms唯一标识squenceId
        } catch (Exception ex) {
            return handlerException(ex, "提交联通短邮发送内容", dto);
        }
    }

    /**
     * 联通能力开放平台短邮提交
     *
     * @param dto
     * @return
     */
    @PostMapping(value = "/sjnSubmitsmsmailToUc", produces = {"application/json;charset=UTF-8"})
    public String sjnSubmitsmsamilToUc(@RequestBody SmsmailDTO dto, HttpServletRequest request) {
        String remoteIp = null;
        remoteIp = IPUtils.getRemoteHost(request);
        if (!clientIp.contains(remoteIp)) {
            log.info("请求失败！" + remoteIp);
            return "请求失败！" + remoteIp;
        }
        try {
            Object data = nceMailAndSmsService.sendNcEmailAndSmsTask(dto);
            return handlerListResult(data, 0);
        } catch (Exception ex) {
            return handlerException(ex, "提交联通短邮发送内容", dto);
        }
    }

    /**
     * 联通能力开放平台短邮发送状态通知回调
     *
     * @param dto
     * @return
     */
    @PostMapping(value = "/notify", produces = {"application/json;charset=UTF-8"})
    public String UcToSjnNotify(@RequestBody SmsmailDTO dto) {
        try {
            int retCode = nceMailAndSmsService.updateUcNotifystat(dto);
            log.info("ChannelId:" + dto.getChannelId());
            log.info("SendDate:" + dto.getSendDate());
            log.info("SequenceId:" + dto.getSequenceId());
            log.info("TaskId:" + dto.getTaskId());
            log.info("TaskTypeId:" + dto.getTaskTypeId());
            log.info("Recipient:" + dto.getRecipient());
            log.info("StatusId:" + dto.getStatusId());
            log.info("errorCode:" + dto.getErrorCode());

            return String.valueOf(retCode);
        } catch (Exception ex) {
            return handlerException(ex, "接收联通开放平台短邮任务状态同步通知", dto);
        }
    }


}
