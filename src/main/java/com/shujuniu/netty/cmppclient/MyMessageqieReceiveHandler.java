package com.shujuniu.netty.cmppclient;


import com.shujuniu.haod.service.HaodService;
import com.shujuniu.sjnsmsmt.dto.MtDTO;
import com.shujuniu.sjnsmsmt.service.MtAddService;
import com.zx.sms.codec.cmpp.msg.*;
import com.zx.sms.common.util.CachedMillisecondClock;
import com.zx.sms.common.util.MsgId;
import com.zx.sms.connect.manager.EndpointManager;
import com.zx.sms.connect.manager.EventLoopGroupFactory;
import com.zx.sms.connect.manager.ExitUnlimitCirclePolicy;
import com.zx.sms.session.cmpp.SessionState;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by LuoBin 2019/6/19 16:31
 */

@ChannelHandler.Sharable
public class MyMessageqieReceiveHandler extends MessageReceiveHandler {
    private static final Logger logger = LoggerFactory.getLogger(MyMessageqieReceiveHandler.class);
    private int rate = 1;
    private AtomicLong cnt = new AtomicLong();
    private long lastNum = 0;
    private volatile boolean inited = false;

    @Autowired
    private final HaodService haodService;
    private final MtAddService mtAddService;

    public MyMessageqieReceiveHandler(HaodService haodService, MtAddService mtAddService) {
        this.haodService = haodService;
        this.mtAddService = mtAddService;
    }


    @Override
    public String name() {
        return "MyMessageqieReceiveHandler-smsBiz";
    }

    @Override
    public synchronized void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt == SessionState.Connect && !inited) {
            EventLoopGroupFactory.INS.submitUnlimitCircleTask(new Callable<Boolean>() {

                @Override
                public Boolean call() {
                    long nowcnt = cnt.get();
                    logger.info("channels : {},Totle Receive Msg Num:{},   speed : {}/s", EndpointManager.INS.getEndpointConnector(getEndpointEntity()).getConnectionNum(), nowcnt, (nowcnt - lastNum) / rate);
                    lastNum = nowcnt;
                    return true;
                }
            }, new ExitUnlimitCirclePolicy() {
                @Override
                public boolean notOver(Future future) {
                    return true;
                }
            }, rate * 1000);
            inited = true;
        }
        ctx.fireUserEventTriggered(evt);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        if (msg instanceof CmppDeliverRequestMessage) {
            CmppDeliverRequestMessage e = (CmppDeliverRequestMessage) msg;
            //int registeredDelivery =e.getRegisteredDelivery();
            boolean isReport = e.isReport();
            logger.warn("收到isReport值:" + isReport);
            if (!isReport) {
                logger.warn("收到上行的状态报告" + e.toString());
//                logger.warn("收到上行的状态报告" +ToStringBuilder.reflectionToString(msg));
                String msgcontent = ((CmppDeliverRequestMessage) msg).getMsgContent();//内容
                String mobile = ((CmppDeliverRequestMessage) msg).getSrcterminalId();//手机号
                String destid = ((CmppDeliverRequestMessage) msg).getDestId();//完整码号
                int mh = Integer.valueOf(((CmppDeliverRequestMessage) msg).getDestId().substring(0, 8));
                int bh = Integer.valueOf(((CmppDeliverRequestMessage) msg).getDestId().substring(9, ((CmppDeliverRequestMessage) msg).getDestId().length()));
//                        CmppDeliverResponseMessage responseMessage = new CmppDeliverResponseMessage(e.getHeader().getSequenceId());
//      x                  responseMessage.setResult(0);
//                        ctx.channel().writeAndFlush(responseMessage);
//                logger.warn("收到上行内容" + msgcontent);
//                logger.warn("收到上行信息" + "内容："+msgcontent+"完整码号："+destid+"手机号："+mobile);

//                    hd.updateOrderOrReplyStatus("1003","","",0,mobile,destid,msgcontent,e.toString()+ToStringBuilder.reflectionToString(msg),0);
//                    logger.warn("更新上行完成" );

            } else if (isReport) {
                CmppReportRequestMessage reportRequestMessage = ((CmppDeliverRequestMessage) msg).getReportRequestMessage();
                MsgId msgId = reportRequestMessage.getMsgId();
                logger.warn("收到回调的状态报告:" + e.toString());
//                logger.warn("收到回调短信状态报告" + ToStringBuilder.reflectionToString(msg));
                String stat = ((CmppDeliverRequestMessage) msg).getReportRequestMessage().getStat();
                String mobile = ((CmppDeliverRequestMessage) msg).getReportRequestMessage().getDestterminalId();
                String destid = ((CmppDeliverRequestMessage) msg).getDestId();//完整码号

                String out = e.getMsgId().toString();
//                logger.warn("码号" + destid);
//                logger.warn("外围的msgID" + out);
//                logger.warn("内围的msgID" + msgId.toString());
//                logger.warn("收到回调信息" + "外围id：" + out + "内围的msgID：" + msgId.toString() + "完整码号：" + destid + "手机号：" + mobile + "状态：" + stat);

                CmppDeliverResponseMessage responseMessage = new CmppDeliverResponseMessage(e.getHeader().getSequenceId());
                responseMessage.setResult(0);
                ctx.channel().writeAndFlush(responseMessage);
                logger.info("stat:{}", stat);
                if ("DELIVRD".equals(stat) || "ACCEPTED".equals(stat)) {
//                        hd.updateOrderOrReplyStatus("1003",msgId.toString(),"",1,mobile,destid,"",e.toString()+ToStringBuilder.reflectionToString(msg),1);

                } else {
//                        hd.updateOrderOrReplyStatus("1003",msgId.toString(),`"",-1,mobile,destid,"",e.toString()+ToStringBuilder.reflectionToString(msg),1);

                }
//                MtDTO mtDTO1 = new MtDTO();
//                mtDTO1.setMsgid(msgId.toString());
//                mtDTO1.setStatus(stat);

//                ZonedDateTime now = ZonedDateTime.now();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//                (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).parse(now.format(formatter))
//                mtDTO1.setRptime(new Date());

//                mtAddService.update(mtDTO1);
                logger.warn("更新回调完成#################################################");

            } else {
                logger.warn("registeredDelivery不是1也不是0");
                CmppDeliverResponseMessage responseMessage = new CmppDeliverResponseMessage(e.getHeader().getSequenceId());
                responseMessage.setResult(9);
                ctx.channel().writeAndFlush(responseMessage);
            }
        } else if (msg instanceof CmppDeliverResponseMessage) {
            CmppDeliverResponseMessage e = (CmppDeliverResponseMessage) msg;

        } else if (msg instanceof CmppSubmitRequestMessage) {
            CmppSubmitRequestMessage e = (CmppSubmitRequestMessage) msg;
            CmppSubmitResponseMessage resp = new CmppSubmitResponseMessage(e.getHeader().getSequenceId());
            resp.setResult(0);
            ctx.channel().writeAndFlush(resp);
        } else if (msg instanceof CmppSubmitResponseMessage) {
//            logger.warn("收到提交报告" + ToStringBuilder.reflectionToString(msg));
            CmppSubmitResponseMessage e = (CmppSubmitResponseMessage) msg;
            CmppSubmitRequestMessage e2 = (CmppSubmitRequestMessage) e.getRequest();

            String msgId = e.getMsgId().toString();//外围主键id，用于更新回调内围的id
            String seqid = String.valueOf(e.getHeader().getSequenceId());//取得请求头里面的seqid
            String statue = String.valueOf(((CmppSubmitResponseMessage) msg).getResult());//提交结果
            String mobile[] = e2.getDestterminalId();//手机号
            String srcId = e2.getSrcId();//手机号
            String bid = String.valueOf(((CmppSubmitResponseMessage) msg).getHeader());

            logger.warn("收到提交报告信息" + "外围id：" + msgId + "seqid：" + seqid + "statue状态：" + statue + "手机号：" + mobile[0] + "码号：" + srcId + "bid=" + bid);
            logger.warn("e2.getMsgid():" + e2.getMsgid());
            logger.warn("e2.getPknumber():" + e2.getPknumber());
            logger.warn("e2.getSrcId():" + e2.getSrcId());
            logger.warn("e2.getMsgContent():" + e2.getMsgContent());
            logger.warn("e2.getServiceId():" + e2.getServiceId());
            logger.warn("e2.getMsgid():" + e2.getMsgid());
            logger.warn("e2.getMsgid():" + e2.getMsgid());

//            MtDTO mtDTO = new MtDTO();
//            mtDTO.setMobile(mobile[0]);
//            mtDTO.setStatus(statue);
//            mtDTO.setMsgid(msgId);
//            mtDTO.setSequenceid(seqid);
//            mtDTO.setSrcid(srcId);
//            mtDTO.setMsgcontent(e2.getMsgContent().toString());
//
////            ZonedDateTime now = ZonedDateTime.now();
////            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//            //                mtDTO.setCtime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).parse(now.format(formatter)));
////            mtDTO.setCtime(new Date());
//            mtDTO.setMsgsrc(srcId);
////            mtDTO.setDestterminalid(e2.getDestterminalId());
////            mtDTO.setServiceid(e2.getServiceId());
//            System.out.printf("---------------------insetSelective mtDTO--------------------" + mtDTO.toString());
//            mtAddService.insert(mtDTO);

        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    protected ChannelFuture reponse(final ChannelHandlerContext ctx, Object msg) {
        logger.warn("#################################################");
        logger.warn("####################response######################");
        logger.warn(ToStringBuilder.reflectionToString(msg));
        logger.warn("#################################################");
        if (msg instanceof CmppDeliverRequestMessage) {
            CmppDeliverRequestMessage e = (CmppDeliverRequestMessage) msg;


            if (e.getFragments() != null) {
                //长短信会带有片断
                for (CmppDeliverRequestMessage frag : e.getFragments()) {
                    CmppDeliverResponseMessage responseMessage = new CmppDeliverResponseMessage(frag.getHeader().getSequenceId());
                    responseMessage.setResult(0);
                    responseMessage.setMsgId(frag.getMsgId());
                    ctx.channel().write(responseMessage);
                }
            }

            CmppDeliverResponseMessage responseMessage = new CmppDeliverResponseMessage(e.getHeader().getSequenceId());
            responseMessage.setResult(0);
            responseMessage.setMsgId(e.getMsgId());
            return ctx.channel().writeAndFlush(responseMessage);

        } else if (msg instanceof CmppSubmitRequestMessage) {
            //接收到 CmppSubmitRequestMessage 消息
            CmppSubmitRequestMessage e = (CmppSubmitRequestMessage) msg;

            final List<CmppDeliverRequestMessage> reportlist = new ArrayList<CmppDeliverRequestMessage>();

            if (e.getFragments() != null) {
                //长短信会可能带有片断，每个片断都要回复一个response
                for (CmppSubmitRequestMessage frag : e.getFragments()) {
                    CmppSubmitResponseMessage responseMessage = new CmppSubmitResponseMessage(frag.getHeader().getSequenceId());
                    responseMessage.setResult(0);
                    ctx.channel().write(responseMessage);

                    CmppDeliverRequestMessage deliver = new CmppDeliverRequestMessage();
                    deliver.setDestId(e.getSrcId());
                    deliver.setSrcterminalId(e.getDestterminalId()[0]);
                    CmppReportRequestMessage report = new CmppReportRequestMessage();
                    report.setDestterminalId(deliver.getSrcterminalId());
                    report.setMsgId(responseMessage.getMsgId());
                    String t = DateFormatUtils.format(CachedMillisecondClock.INS.now(), "yyMMddHHMM");
                    report.setSubmitTime(t);
                    report.setDoneTime(t);
                    report.setStat("DELIVRD");
                    report.setSmscSequence(0);
                    deliver.setReportRequestMessage(report);
                    reportlist.add(deliver);
                }
            }

            final CmppSubmitResponseMessage resp = new CmppSubmitResponseMessage(e.getHeader().getSequenceId());
            resp.setResult(0);

            ChannelFuture future = ctx.channel().writeAndFlush(resp);

            //回复状态报告
            if (e.getRegisteredDelivery() == 1) {

                final CmppDeliverRequestMessage deliver = new CmppDeliverRequestMessage();
                deliver.setDestId(e.getSrcId());
                deliver.setSrcterminalId(e.getDestterminalId()[0]);
                CmppReportRequestMessage report = new CmppReportRequestMessage();
                report.setDestterminalId(deliver.getSrcterminalId());
                report.setMsgId(resp.getMsgId());
                String t = DateFormatUtils.format(CachedMillisecondClock.INS.now(), "yyMMddHHMM");
                report.setSubmitTime(t);
                report.setDoneTime(t);
                report.setStat("DELIVRD");
                report.setSmscSequence(0);
                deliver.setReportRequestMessage(report);
                reportlist.add(deliver);

                ctx.executor().submit(new Runnable() {
                    public void run() {
                        for (CmppDeliverRequestMessage t : reportlist)
                            ctx.channel().writeAndFlush(t);
                    }
                });
            }
            return future;
        } else if (msg instanceof CmppQueryRequestMessage) {
            CmppQueryRequestMessage e = (CmppQueryRequestMessage) msg;
            CmppQueryResponseMessage res = new CmppQueryResponseMessage(e.getHeader().getSequenceId());
            return ctx.channel().writeAndFlush(res);
        }
        return null;
    }

}
