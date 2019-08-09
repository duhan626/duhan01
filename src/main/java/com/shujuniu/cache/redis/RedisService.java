package com.shujuniu.cache.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.SortingParams;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("redisService")
@Slf4j
public class RedisService {

    //设置锁的lua脚本
    private static final String SET_IFEXIST_SCRIPT =
            "if redis.call('get',KEYS[1]) == KEYS[2] then\n"
                    + "return redis.call('SET', KEYS[1], KEYS[3])\n"
                    + "end\n"
                    + "return nil;";
    private static final String CHARSET_NAME = "UTF-8";
    @Resource
    private JedisPool jedisPool;


    /**
     * 指定具体的过期时间点
     * 例：2020年02月02日02点02分02秒
     *
     * @param key
     * @param timestamp
     */
    public void expireAt(String key, long timestamp) {
        Jedis jedis = jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.expireAt(key, timestamp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 控制 同一个key 一秒钟只能保存一次
     *
     * @param key
     * @param value
     * @param liveTime
     * @return
     */
    public boolean setNxt(String key, String value, int liveTime) {
        boolean flag = true;
        Jedis jedis = jedisPool.getResource();
        try {
            if (!StringUtils.isEmpty(value)) {
                if ((jedis != null ? jedis.setnx(key, value).intValue() : 0) == 1) {
                    jedis.expire(key, liveTime);
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = true;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return flag;
    }


    /**
     * 增量+1
     *
     * @param key
     * @return
     */
    public int incrby(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.incrBy(key, 1).intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    public Set<String> pattern(String pattern) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.keys(pattern) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 追加字符
     *
     * @param key
     * @param value
     */
    public void append(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.append(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 排序(适用set,sortset,list这3种数据类型)
     *
     * @param key
     * @param sortingParams
     */
    public List<String> sort(String key, SortingParams sortingParams) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.sort(key, sortingParams) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * Map:
     * 添加map
     *
     * @param key
     * @param map
     */
    public void mapSets(String key, Map<String, String> map) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.hmset(key, map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 添加
     *
     * @param key
     * @param mapKey
     * @param mapValue
     */
    public void mapSet(String key, String mapKey, String mapValue) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.hset(key, mapKey, mapValue);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 删除指定map集合内的数据
     *
     * @param key
     * @param mapKeys
     */
    public void mapDels(String key, String... mapKeys) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.hdel(key, mapKeys);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 遍历集合
     *
     * @param key
     * @return
     */
    public List<String> mapGets(String key, String... mapKeys) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.hmget(key, mapKeys) : null;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 获取某个map的value
     *
     * @param key
     * @param mapKey
     * @return
     */
    public String mapGet(String key, String mapKey) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.hget(key, mapKey) : null;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 遍历key下所有的hash数据
     *
     * @param key
     * @return
     */
    public List<String> mapGetValueAll(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.hvals(key) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 遍历key下所有的hash数据(包含map的key与value值)
     *
     * @param key
     * @return
     */
    public Map<String, String> mapGetAll(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.hgetAll(key) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 遍历key下所有的map key 值
     *
     * @param key
     * @return
     */
    public Set<String> mapGetKeys(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.hkeys(key) : null;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 获取集合大小
     *
     * @param key
     * @return
     */
    public Long mapSize(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.hlen(key) : null;
        } catch (Exception e) {

            e.printStackTrace();
            return 0L;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Map:
     * 增量 increment
     *
     * @param key
     * @param mapKey
     * @param increment
     * @return
     */
    public Long mapIncrby(String key, String mapKey, int increment) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.hincrBy(key, mapKey, increment) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0L;
    }

    /**
     * List:
     * list入对列
     *
     * @param key
     * @param value
     */
    public void lstPush(String key, String value) {
        // 本地缓存后入队列
        Jedis jedis = jedisPool.getResource();
        try {
            if (!StringUtils.isEmpty(value)) {
                if (jedis != null) {
                    jedis.rpush(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * List:
     * 入对列
     *
     * @param key
     * @param value 一次多条
     */
    public void lstPushs(String key, String... value) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.rpush(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * List:
     * 出对列
     *
     * @param key
     */
    public String lstPop(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.lpop(key) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * List:
     * 移除指定key下size个value元素
     * size=2为从顶部移除值为value的2个元素
     * size=-2为从底部移除值为value的2个元素
     *
     * @param key
     * @param size
     * @param value
     */
    public void lstRemove(String key, long size, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.lrem(key, size, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * List:
     * 获取list列表
     *
     * @param key
     * @param start 0
     * @param end   -1 可查全部
     * @return
     */
    public List<String> lstAll(String key, long start, long end) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.lrange(key, start, end) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * List:
     * list size
     *
     * @param key
     * @return
     */
    public Long lstSize(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.llen(key) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * List:
     * 返回列表 key 中，下标为 index 的元素
     *
     * @param key
     * @param index
     * @return
     */
    public String lstIndex(String key, int index) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.lindex(key, index) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * List:
     * 裁剪指定范围的list,也就是只保留这个范围内的数据
     *
     * @param key
     * @param start
     * @param end
     */
    public void lstTrim(String key, long start, long end) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.ltrim(key, start, end);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Set:
     * 添加元素
     *
     * @param key
     * @param values 可多个value
     */
    public void setAdds(String key, String... values) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.sadd(key, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Set:
     * 遍历集合
     *
     * @param key
     * @return
     */
    public Set<String> setGet(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.smembers(key) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * Set:
     * 删除集合里的元素
     *
     * @param key
     * @param value
     */
    public void setRemove(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                jedis.srem(key, value);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Set:
     * 集合大小
     *
     * @param key
     * @return
     */
    public Long setSize(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.scard(key) : null;
        } catch (Exception e) {

            e.printStackTrace();
            return 0L;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Set:
     * 判断集合中某元素是否存在
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean setExist(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.sismember(key, value) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 发布消息
     *
     * @param channel
     * @param message
     * @return
     */
    public Long pub(String channel, String message) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.publish(channel, message) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @param key
     * @return
     */
    public Long getKeyLiveTime(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.ttl(key) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * 仅当存在同名key并且value也一致时设置key
     *
     * @param key      键名
     * @param oldValue 原键值
     * @param newValue 新键值
     * @return 成功返回true, 失败false
     */
    public boolean setIfExiseByScript(String key, String oldValue, String newValue) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis != null) {
                Object result = jedis.eval(SET_IFEXIST_SCRIPT, 3, key, oldValue, newValue);
                return result == null ? false : ("OK".equals(result));
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * 设置新值并返回旧值
     *
     * @param key   键名
     * @param value 新值
     * @return 成功返回旧值, 失败返回null
     */
    public String getSet(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.getSet(key, value) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 存放对象
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public  void set(byte[] key, byte[] value, int liveTime) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (value != null && value.length > 0) {
                if (jedis != null) {
                    jedis.set(key, value);
                    jedis.expire(key, liveTime);
                    log.info("redis set key=" + key + "&value=" + value + "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 删除key
     *
     * @param key
     */
    public  void del(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (key != null && key.length > 0) {
                if (jedis != null) {
                    jedis.del(key);
                    log.info("redis delete key=" + key);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * 获取redis value (byte数组)
     *
     * @param key
     * @return
     */
    public  byte[] get(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        try {
            log.info("redis get key="+key);
            return jedis != null ? jedis.get(key) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    public  String get(String key) {
        Jedis jedis =jedisPool.getResource();
        try {
            String value = jedis != null ? jedis.get(key) : null;
            log.info("redis get key=" + key + "&value=" + value + "");
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }



    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public  void set(String key, String value) {
        Jedis jedis =jedisPool.getResource();
        try {
            if (!com.alibaba.druid.util.StringUtils.isEmpty(value)) {
                if (jedis != null) {
                    String code = jedis.set(key, value);
                    log.info("redis set key=" + key + "&value=" + value + "&status=" + code + "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public  void set(String key, String value, int liveTime) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (!com.alibaba.druid.util.StringUtils.isEmpty(value)) {
                if (jedis != null) {
                    String code = jedis.set(key, value);
                    log.info("redis set key=" + key + "&value=" + value + "&status=" + code + "");
                    jedis.expire(key, liveTime);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    public  boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.exists(key) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    public long ttl(String key) {
        Jedis  jedis = jedisPool.getResource();
        try {
            return jedis != null ? jedis.ttl(key) : -2;
        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }



    /**
     * expire
     *
     * @param key
     * @param second
     * @return long
     */

    public long expire(String key, int second) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.expire(key, second);
        } catch (Exception e) {
            log.warn("expire {} = {}", key, second, e);
        } finally {
            if (jedis != null) {
                jedis.close();
                log.debug("return jedis connection to jedisPool!");
            }
        }
        return result;
    }

    /**
     * exist
     *
     * @param key
     * @return boolean
     */
    public boolean exist(String key) {
        Boolean result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.exists(key);
        } catch (Exception e) {
            log.warn("exist {} = {}", key, result, e);
        } finally {
            if (jedis != null) {
                jedis.close();
                log.debug("return jedis connection to jedisPool!");
            }
        }
        return result;
    }

    /**
     * SET
     *
     * @param key
     * @param value
     * @return
     */
    public String setString(String key, String value) {
        return setString(key, value, -1);
    }

    /**
     * SET  +   expire
     *
     * @param key
     * @param value
     * @param second
     * @return
     */

    public String setString(String key, String value, int second) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.set(key, value);
            if (second > 0) {
                jedis.expire(key, second);
            }
            log.debug("set {} = {}", key, value);
        } catch (Exception e) {
            log.warn("set {} = {}", key, value, e);
        } finally {
            if (jedis != null) {
                jedis.close();
                log.debug("return jedis connection to jedisPool!");
            }
        }
        return result;
    }

    /**
     * Get Key
     *
     * @param key
     * @return
     */
    public String getString(String key,int db) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if(db>0){
                jedis.select(db);
            }
            if (jedis.exists(key)) {
                value = jedis.get(key);
                value = StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value) ? value
                        : null;
                log.debug("get {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("get {} = {}", key, value, e);
        } finally {
            if (jedis != null) {
                jedis.close();
                log.debug("return jedis connection to jedisPool!");
            }
        }
        return value;
    }

    /**
     * Get Key
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            if (jedis.exists(key)) {
                value = jedis.get(key);
                value = StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value) ? value
                        : null;
                log.debug("get {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("get {} = {}", key, value, e);
        } finally {
            if (jedis != null) {
                jedis.close();
                log.debug("return jedis connection to jedisPool!");
            }
        }
        return value;
    }
    /**
     * 删除Key
     *
     * @param key
     * @return
     */


    public long del(String key) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                result = jedis.del(key);
                log.debug("del {}", key);
            } else {
                log.debug("del {} not exists", key);
            }
        } catch (Exception e) {
            log.warn("del {}", key, e);
        } finally {
            if (jedis != null) {
                jedis.close();
                log.debug("return jedis connection to jedisPool!");
            }
        }
        return result;
    }
}
