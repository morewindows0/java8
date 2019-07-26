package com.dev.java.test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: dengxin.chen
 * @date: 2019/5/22 17:52
 * @description: 权重测试
 */
public class WeightTest {

    //    柴油：排队（10%）、环境（30%）、位置（30%）、态度（30%）

    //    LNG、CNG：排队（25%）、环境（25%）、位置（25%）、态度（25%）

    public static void main(String[] args) {
        DateTime dateTime = DateTime.now().minusMonths(6).withTimeAtStartOfDay();

        Map<String, Integer> dataMap = Maps.newHashMap();
        dataMap.put("排队", 10);
        dataMap.put("环境", 30);
        dataMap.put("位置", 30);
        dataMap.put("态度", 30);
        Map<String, Integer> dataMap1 = Maps.newHashMap();
        dataMap1.put("排队", 10);
        dataMap1.put("环境", 30);
        dataMap1.put("态度", 301);
        dataMap1.put("位置", 30);
        int i = dataMap.hashCode();
        int i11 = dataMap1.hashCode();
        testProcess(dataMap);
        int i1 = dataMap.hashCode();
        List<String> list = Lists.newArrayList();
        list.add("排队");
        list.add("环境");
        list.add("位置");
        list.add("态度");
        List<String> weightValue = getWeightValue(dataMap, list);
        System.out.println(weightValue);

    }

    public static List<String> getWeightValue(Map<String, Integer> config, List<String> inputList) {
        if (MapUtils.isEmpty(config)) {
            // 随机乱序
            Collections.shuffle(inputList, new Random());
            return inputList;
        }
        List<String> weightResult = Lists.newArrayList();

        config.entrySet().parallelStream().forEach(e -> {
            for (int index = 0, size = e.getValue(); index < size; index++) {
                weightResult.add(e.getKey());
            }
        });

        int randomPos = RandomUtils.nextInt(0, 100);
        System.out.println(randomPos);
        String key = weightResult.get(randomPos);
        Optional<String> collect = inputList.stream().filter(e -> e.equals(key)).findFirst();
        if (collect.isPresent()) {
            List<String> collect1 = inputList.stream().filter(e -> !e.equals(key)).collect(Collectors.toList());
            collect1.add(0, collect.get());
            return collect1;
        }
        // 抽取乱序公共方法进行返回即可
        return inputList;
    }

    public static void testProcess(Map<String, Integer> map) {
        map.put("test", 20);
    }
}

enum testE {
    WAIT_AUDIT("待审核", 0),
    PASS("审核通过", 1),
    REJECT("审核未通过", 2),
    UNKNOWN("未知状态", 9);

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int index;

    testE(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
