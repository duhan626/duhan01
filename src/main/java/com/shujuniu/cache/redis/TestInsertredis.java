package com.shujuniu.cache.redis;

import com.shujuniu.cache.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import javax.annotation.Resource;
import java.io.IOException;

public class TestInsertredis {
    @Autowired
    private RedisService redisService;
    private RedisConfig redisConfig;
    @Resource
    private static JedisPool jedisPool;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Jedis jedis = jedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();
        jedis.set("count1","0");
        for(int i=0;i<10000;i++){
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
        System.out.println("使用Piple耗时"+(end-start)+"ms");

    }

}
