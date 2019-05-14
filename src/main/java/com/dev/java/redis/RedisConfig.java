package com.dev.java.redis;

import java.util.Objects;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: dengxin.chen
 * @date: 2019/4/25 16:17
 * @description:
 */
public class RedisConfig {

    /**
     * redis服务器地址
     */
    private static String HOST = "127.0.0.1";

    /**
     * redis 端口号
     */
    private static int PORT = 6379;


    private static JedisPool jedisPool = null;

    /**
     * 初始化redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(20);
            config.setMaxIdle(5);
            config.setMaxWaitMillis(1000l);
            config.setTestOnBorrow(false);
            jedisPool = new JedisPool(config, HOST, PORT);
        } catch (Exception e) {
            throw new RuntimeException("初始化redis连接池异常", e);
        }
    }

    /**
     * 获取redis连接
     *
     * @return
     */
    public synchronized static Jedis getJedis() {

        try {
            if (Objects.nonNull(jedisPool)) {
                return jedisPool.getResource();
            }
            return null;

        } catch (Exception e) {
            throw new RuntimeException("获取redis连接异常", e);
        }
    }

    /**
     * 关闭redis
     *
     * @param jedis
     */
    public static void closeRedis(Jedis jedis) {
        if (Objects.nonNull(jedis)) {
            jedis.close();
        }
    }
}
