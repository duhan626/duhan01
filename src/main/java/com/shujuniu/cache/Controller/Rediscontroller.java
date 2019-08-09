package com.shujuniu.cache.Controller;


import com.shujuniu.cache.redis.RedisService;
import com.shujuniu.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/redis")
public class Rediscontroller extends BaseController {
    @Autowired
    private RedisService redisService;
    //    private RedisConfig redisConfig;
    @Resource
    private  JedisPool jedisPool;

    @RequestMapping("redisgetkey")
    public String redisQuery(String keyString,int db) {
        return redisService.getString(keyString,db);
    }

    @RequestMapping("redissetString")
    public String redisUpdate(String keyString, String valueString) {
        redisService.set(keyString, valueString);
        return "OK";
    }

    @RequestMapping("Testredis")
    public String redisTest() {
        long start = System.currentTimeMillis();
        Jedis jedis = jedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();
        jedis.select(2);
        jedis.set("count1", "0");
        for (int i = 0; i < 1000000; i++) {
            pipeline.incr("count1");
        }
        pipeline.sync();
        pipeline.get("coun1");
        try {
            pipeline.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用Piple耗时" + (end - start) + "ms");

        return "使用Piple耗时" + (end - start) + "ms";
    }
    @RequestMapping("TestredisNopipelined")
    public String redisTestNopipelined() {
        long start = System.currentTimeMillis();
        Jedis jedis = jedisPool.getResource();
        jedis.select(2);
        jedis.set("count2","0");

        for (int i = 0; i < 1000000; i++) {
            jedis.incr("count2");
        }

        jedis.get("coun2");

            jedis.close();

        long end = System.currentTimeMillis();
        System.out.println("不使用Piple耗时" + (end - start) + "ms");

        return "不使用Piple耗时" + (end - start) + "ms";
    }


}
