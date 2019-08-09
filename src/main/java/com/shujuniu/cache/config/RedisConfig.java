package com.shujuniu.cache.config;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Autowired
    private Environment env;

    @SuppressWarnings("unused")
    @Bean("Jedis")
    public JedisPool getJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();

        String host = env.getProperty("spring.redis.host");
        Integer port = env.getProperty("spring.redis.port", Integer.class);
        String password = env.getProperty("spring.redis.password");
        String maxTotal = env.getProperty("spring.redis.maxTotal");
        String maxIdle = env.getProperty("spring.redis.maxIdle");
        String maxWaitMills = env.getProperty("spring.redis.maxWaitMills");
        String testOnBorrow = env.getProperty("spring.redis.testOnBorrow");

        config.setMaxTotal(Integer.valueOf(maxTotal));
        config.setMaxIdle(Integer.valueOf(maxIdle));
        config.setMaxWaitMillis(Integer.valueOf(maxWaitMills));
        config.setTestOnBorrow(Boolean.valueOf(testOnBorrow));

        JedisPool jedisPool;
        if (config != null && StringUtils.isNotEmpty(password)) {
            jedisPool = new JedisPool(config, host, port, 3000, password);
        }else   if (config != null ) {
            jedisPool = new JedisPool(config, host, port);
        } else {
            jedisPool = new JedisPool(config, host, port);
        }
        
        return jedisPool;
    }
}