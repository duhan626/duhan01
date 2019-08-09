//package com.shujuniu.web.task;
//
//import DateParttern;
//import DateUtils;
//import WxSendMessageService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//@Slf4j
//public class SendDailyTask extends BaseTask {
//    @Autowired
//    private WxSendMessageService wxSendMessageService;
//    /**
//     * 定时发送前一天的异常出场报告
//     * 目前 9点发送
//     */
//    @Scheduled(cron ="0 0 9 * * ? ")
//    public void initBookArriveStoreData(){
//        log.info(">>>>>>>>>>>>>>>>>初始化预约到店数据开始" + DateUtils.date2Str(new Date(), DateParttern.YYYY_MM_DD_HH_MM_SS));
//
//        wxSendMessageService.sendDailyReport();
//
//        log.info(">>>>>>>>>>>>>>>>初始化预约到店数据结束" + DateUtils.date2Str(new Date(), DateParttern.YYYY_MM_DD_HH_MM_SS));
//    }
//}
