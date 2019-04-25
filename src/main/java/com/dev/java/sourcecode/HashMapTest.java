package com.dev.java.sourcecode;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author: dengxin.chen
 * @date: 2019/2/27 14:56
 * @description:hashMap测试
 */
public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> hashMap = Maps.newHashMap();
        hashMap.put("1", "t1");
        hashMap.put("2", "t2");

        for (String key : hashMap.keySet()) {
            if ("2".equals(key)) {
                hashMap.remove(key);
            }
        }
        System.out.println(hashMap);
    }




}
