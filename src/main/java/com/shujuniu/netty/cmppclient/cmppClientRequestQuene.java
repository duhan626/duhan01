package com.shujuniu.netty.cmppclient;

public class cmppClientRequestQuene {

    //客户提交过来的数据存BID，然后放到BF表，CMPP网关从BF队列取数据发送的短信给上家。
    //如果发送成功，调存储过程，写MT

    //如果状态回调，更新MT，放到RPT表，推送给客户。
}
