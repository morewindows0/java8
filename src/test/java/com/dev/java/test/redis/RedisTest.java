package com.dev.java.test.redis;

import org.junit.Test;

import com.dev.java.redis.RedisConfig;
import com.dev.java.redis.RedisDelayingQueue;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * @author: dengxin.chen
 * @date: 2019/4/25 16:29
 * @description:
 */

public class RedisTest {

    private Jedis jedis = RedisConfig.getJedis();

    @Test
    public void addTest() {
        for (int i = 0; i < 10000; i++) {
            jedis.set("key" + i, i + "");
        }
    }


    /**
     * 通过该方式设置分布式锁，确保原子操作不会出现问题
     */
    @Test
    public void setDistributedLock() {
        SetParams params = new SetParams();
        params.ex(10).nx();
        jedis.set(this.getClass() + ":lock", "分布式锁", params);
    }

    @Test
    public void delayQueueTest() throws InterruptedException {
        Jedis jedis = RedisConfig.getJedis();
        RedisDelayingQueue<String> queue = new RedisDelayingQueue<>(jedis, "queue-demo");
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.delay("codehole" + i);
            }
        });

        Thread consumer = new Thread(() -> queue.loop());

        producer.start();
        Thread.sleep(100);
        consumer.start();

        try {
            producer.join();
            Thread.sleep(3000);
            queue.setStopFlag(true);
            consumer.join();
        } catch (Exception e) {
        }
        RedisConfig.closeRedis(jedis);
    }
}
