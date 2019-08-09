package com.shujuniu.mq.activemq.controler;
/**
 * Created by LuoCY 2019/6/12
 */


import com.google.common.base.Splitter;
import com.shujuniu.chinaunionopen.DTO.SmsmailDTO;
import com.shujuniu.chinaunionopen.mapper.NceMailAndSmsMapper;
import com.shujuniu.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 消息生产者
 *
 * @author luocy
 */
@Slf4j
@RestController
public class ActiveMqController {
    @Value("${chinauionopen.clientIp}")
    private String clientIp; //请求客户端IP

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    private NceMailAndSmsMapper nceMailAndSmsMapper;

    /**
     * 提交MT给新CMPP网关发送短信模块入队
     *
     * @param ip
     * @param port
     * @param userName
     * @param mobile
     * @param password
     * @param clientId
     * @param maxChannels
     * @param writeLimit
     * @param content
     * @param srcId
     * @param serviceId
     * @return
     */

    @RequestMapping("/submitRequestSms")
    public String submitRequestSms(String ip, Integer port, String userName, String mobile, String password, String clientId,
                                   short maxChannels, Integer writeLimit, String content, String srcId, String serviceId, HttpServletRequest request) {
        String remoteIp = null;
        remoteIp = IPUtils.getRemoteHost(request);
        if (clientIp.contains(remoteIp)) {
            Map map = new HashMap<>();
            map.put("mobile", mobile);
            map.put("ip", ip);
            map.put("port", port);
            map.put("userName", userName);
            map.put("password", password);
            map.put("clientId", clientId);
            map.put("writeLimit", writeLimit);
            map.put("content", content);
            map.put("maxChannels", maxChannels);
            map.put("srcId", srcId);
            map.put("serviceId", serviceId);
            jmsMessagingTemplate.convertAndSend("sjnsms_submit_map", map);
            return "ok";
        } else {
            return "请求无效！" + remoteIp;
        }
    }

    /**
     * 提交MT给联通开放短邮入队
     *
     * @return
     */

    @RequestMapping(value = "/bxmtsubmittoucopen", method = RequestMethod.GET)
    public String submitMt(String bid, Integer uid, Integer gwid, String mb, String sc,
                           String p, String c, Byte pt, Byte pu, Byte oper, String mid, String emmid, String code, Integer appid, HttpServletRequest request) {

        try {
//            String reg = "[\u2E80-\u9FFF]";
//            Pattern pat = Pattern.compile(reg);
//            Matcher mat = pat.matcher(code);
//            code = mat.replaceAll("");



            String queryString = request.getQueryString().toString();
            log.info("bxmtsubmittoucopen URL:" + URLDecoder.decode(request.getRequestURL() + "?" + queryString, "GBK"));
//            System.out.println("p:"+new String(p.getBytes(getEncoding(c)),"GBK"));
//            System.out.println("p:"+new String(c.getBytes(getEncoding(c)),"GBK"));
            if(!(queryString.contains("&province=&")||queryString.contains("&city=&"))||queryString.contains("&code=&")) {
                List<String> strList = Splitter.on("&").splitToList(URLDecoder.decode(request.getQueryString()));
                System.out.println(strList);
                for (int i = 0; i < strList.size(); i++) {
                    String firstStr = strList.get(i);
                    if (firstStr.contains("province")) {
                        String[] provnice = firstStr.split("=");
//                        System.out.println(provnice[0]);
//                        System.out.println(provnice[1]);
                        p = provnice[1];
//                    }
                    }
                    if (firstStr.contains("city")) {
                        String[] city = firstStr.split("=");
//                    System.out.println(city[1]);
                        c = city[1];
                    }

                    if (firstStr.contains("code")) {
                        String[] code1 = firstStr.split("=");
//                    System.out.println(city[1]);
                        code = code1[1];
                    }
                }
            }else{
                p="未知";
                c="未知";
            }
            log.info("P-getparameter:" + p);
            log.info("C-getparameter:" + c);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String remoteIp = null;
        remoteIp = IPUtils.getRemoteHost(request);
        if (sc.isEmpty() || sc == null) {
            sc = "10655";
        }
        if (clientIp.contains(remoteIp)) {
            Map map = new HashMap<>();
            map.put("bid", bid);
            map.put("uid", uid);
            map.put("gwid", gwid);
            map.put("mb", mb);
            map.put("sc", sc);
            map.put("p", p);
            map.put("c", c);
            map.put("pt", pt);
            map.put("pu", pu);
            map.put("oper", oper);
            map.put("mid", mid);
            map.put("emmid", emmid);
            map.put("code", code);
            map.put("appid", appid);

            try {
                jmsMessagingTemplate.convertAndSend("bxmtsubmittoucopen", map);
                log.info("AMQ入队成功！" +map);
            } catch (Exception ex) {
                //显示异常，通道状设置为异常
                SmsmailDTO smsmailDTO = new SmsmailDTO();
                smsmailDTO.setGwId(gwid);
                smsmailDTO.setSt("AMQ入队异常" + ex.getMessage());
                nceMailAndSmsMapper.updateByGwidst(smsmailDTO);
            }
            return "ok";
        } else {
            return "请求无效！" + remoteIp;
        }
    }

}
