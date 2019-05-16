package com.dev.java.test.cglibperformance;

import java.util.Map;

import com.dev.java.test.cglibperformance.handler.CglibMethod;
import com.dev.java.test.cglibperformance.impl.BaseCglibTestImpl;
import com.dev.java.test.cglibperformance.impl.CglibProxyCreator;
import com.dev.java.test.cglibperformance.impl.JDKProxyCreator;
import com.google.common.collect.Maps;

/**
 * @author: dengxin.chen
 * @date: 2019/5/16 16:03
 * @description:
 */
public class CGLIBTest {

    public static void main(String[] args) {
        ProxyCreator cglibProxyCreator = new CglibProxyCreator(BaseCglibTestImpl.class, new CglibMethod());
        BaseCglibTest cglibProxy = (BaseCglibTest) cglibProxyCreator.getProxy();
        ProxyCreator jdkProxyCreator = new JDKProxyCreator(new BaseCglibTestImpl());
        BaseCglibTest jdkProxy = (BaseCglibTest) jdkProxyCreator.getProxy();

        //预热
        int cycleCount = 10000;
        runWithoutInfo(jdkProxy, cycleCount);
        runWithoutInfo(cglibProxy, cycleCount);

        Map<String, BaseCglibTest> tests = Maps.newLinkedHashMap();
        tests.put("jdk", jdkProxy);
        tests.put("Cglib", cglibProxy);

        int repeatCount = 3;
        cycleCount = 50000000;
        runTest(repeatCount, cycleCount, tests);

    }

    public static void runTest(int repeatCount, int cycleCount, Map<String, BaseCglibTest> tests) {
        System.out.println(
                String.format("\n==================== run test : [repeatCount=%s] [runCount=%s] [java.version=%s] ====================",
                              repeatCount, cycleCount, System.getProperty("java.version")));

        for (int i = 0; i < repeatCount; i++) {
            System.out.println(String.format("\n--------- test : [%s] ---------", (i + 1)));
            for (String key : tests.keySet()) {
                runWithInfo(tests.get(key), cycleCount, key);
            }
        }


    }

    public static void runWithoutInfo(BaseCglibTest target, int cycleCount) {
        for (int i = 0; i < cycleCount; i++) {
            target.add(i);
        }
    }

    public static void runWithInfo(BaseCglibTest target, int cycleCount, String msg) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < cycleCount; i++) {
            target.add(i);
        }
        long end = System.currentTimeMillis();

        System.out.println("[" + msg + "] Elapsed Time: " + (end - start) + "ms");

    }
}
