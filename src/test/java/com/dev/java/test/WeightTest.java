package com.dev.java.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author: dengxin.chen
 * @date: 2019/5/22 17:52
 * @description: 权重测试
 */
public class WeightTest {

    //    柴油：排队（10%）、环境（30%）、位置（30%）、态度（30%）

    //    LNG、CNG：排队（25%）、环境（25%）、位置（25%）、态度（25%）

    public static void main(String[] args) {
        Map<String, Integer> dataMap = Maps.newHashMap();
        dataMap.put("排队", 10);
        dataMap.put("环境", 30);
        dataMap.put("位置", 30);
        dataMap.put("态度", 30);
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
        }
        config.entrySet().stream().map(e->{

        })
        Iterator<String> iterator = config.keySet().iterator();
        List<String> tmpList = Lists.newArrayList();
        while (iterator.hasNext()) {
            String question = iterator.next();
            int weight = config.get(question);
            for (int i = 0; i < weight; i++) {
                tmpList.add(question);
            }
        }
        Random random = new Random();
        int randomPos = random.nextInt(tmpList.size());
        String key = tmpList.get(randomPos);
        Optional<String> collect = inputList.stream().filter(e -> e.equals(key)).findFirst();
        if (collect.isPresent()) {
            List<String> collect1 = inputList.stream().filter(e -> !e.equals(key)).collect(Collectors.toList());
            collect1.add(0, collect.get());
            return collect1;
        }
        return inputList;
    }
}
