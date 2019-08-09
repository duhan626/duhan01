package com.shujuniu.netty.cmppclient;

import com.shujuniu.haod.service.HaodService;
import com.shujuniu.sjnsmsmt.service.MtAddService;
import com.zx.sms.codec.cmpp.msg.CmppSubmitRequestMessage;
import com.zx.sms.common.util.ChannelUtil;
import com.zx.sms.common.util.MsgId;
import com.zx.sms.connect.manager.EndpointManager;
import com.zx.sms.connect.manager.cmpp.CMPPClientEndpointEntity;
import com.zx.sms.handler.api.BusinessHandlerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luochy 2019/6/9 21:09
 */
@RestController
public class CmppControler {

    @Value("${chinauionopen.clientIp}")
    private String clientIp; //请求客户端IP
    final EndpointManager manager = EndpointManager.INS;
    private final HaodService haodService;
    private MtAddService mtAddService;

    @Autowired
    public CmppControler(HaodService haodService, MtAddService mtAddService) {
        this.haodService = haodService;
        this.mtAddService = mtAddService;

    }

    @RequestMapping("/cmppclient")
    public void cmppControler(String ip, Integer port, String userName, String mobile, String password, String clientId,
                              short maxChannels, Integer writeLimit, String content, String srcId, String serviceId) {
//        String remoteIp = null;
//        remoteIp = IPUtils.getRemoteHost(request);
//        if (!clientIp.contains(remoteIp)) {
//            return;
//        }
//        final EndpointManager manager = EndpointManager.INS;
        CMPPClientEndpointEntity client = new CMPPClientEndpointEntity();
        client.setId(clientId + userName);
        client.setHost(ip);
        client.setPort(port);

        client.setChartset(Charset.forName("UTF-8")); //iso-10646-ucs-2
        client.setGroupName("client_" + userName);
        client.setUserName(userName);
        client.setPassword(password);
        client.setWriteLimit(writeLimit);   //限流200/s
        client.setReadLimit(writeLimit);
        client.setMaxChannels((short) maxChannels);
        client.setVersion((short) 0x20);
        client.setRetryWaitTimeSec((short) 50);
        client.setUseSSL(false);
        client.setReSendFailMsg(true);

        List<BusinessHandlerInterface> clienthHandlerInterfacesandlers = new ArrayList<BusinessHandlerInterface>();
        MyMessageqieReceiveHandler myMessageReceiveHandler = new MyMessageqieReceiveHandler(haodService, mtAddService);
        clienthHandlerInterfacesandlers.add(myMessageReceiveHandler);
        client.setBusinessHandlerSet(clienthHandlerInterfacesandlers);
        manager.addEndpointEntity(client);
        manager.openEndpoint(client);
        manager.startConnectionCheckTask();

        try {
            /**
             * sleep 3s 防止连接没创建好
             */
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        CmppSubmitRequestMessage msg = new CmppSubmitRequestMessage();
        msg.setRegisteredDelivery((short) 1);
        msg.setMsgid(new MsgId());
        msg.setServiceId(serviceId);
        msg.setSrcId(srcId);
        msg.setMsgsrc(userName);
        msg.setPktotal((short) 1);
        msg.setDestterminalId((Long.valueOf(mobile)) + "");
        msg.setMsgContent(content);
        System.out.println("CmppSubmitRequestMessage" + msg);
        try {
            ChannelUtil.syncWriteLongMsgToEntity(clientId + userName, msg);
            Thread.sleep(1000 / writeLimit);
        } catch (Exception e) {
            e.printStackTrace();
            msg = null;
        }
//        LockSupport.park();
//        EndpointManager.INS.close();
    }



}



