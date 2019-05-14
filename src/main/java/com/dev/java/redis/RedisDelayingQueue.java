package com.dev.java.redis;

import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import lombok.Data;
import redis.clients.jedis.Jedis;

/**
 * @author: dengxin.chen
 * @date: 2019/4/25 19:57
 * @description:延时队列
 */
public class RedisDelayingQueue<T> {

    /**
     * 消息体
     *
     * @param <T>
     */
    @Data
    public static class TaskItem<T> {
        public String id;
        public T msg;
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    private volatile boolean stopFlag = false;

    private TypeReference<TaskItem<T>> type = new TypeReference<TaskItem<T>>() {};

    private Jedis jedis;
    private String queueKey;

    public RedisDelayingQueue(Jedis jedis, String queueKey) {
        this.jedis = jedis;
        this.queueKey = queueKey;
    }

    public void delay(T msg) {
        TaskItem<T> task = new TaskItem<>();
        task.id = UUID.randomUUID().toString();
        task.msg = msg;
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, JSON.toJSONString(task));
    }

    public void loop() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.interrupted());
        while (!stopFlag) {
            System.out.println(Thread.interrupted());
            Set<String> value = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (value.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String tmpValue = value.iterator().next();
            if (jedis.zrem(queueKey, tmpValue) > 0) { // 抢到了
                TaskItem<T> task = JSON.parseObject(tmpValue, type);
                this.handleMsg(task.msg);
            }
        }
    }

    public void handleMsg(T msg) {
        System.out.println(msg);
    }

}
