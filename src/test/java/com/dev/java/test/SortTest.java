package com.dev.java.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.dev.java.domain.MuCondition;

/**
 * @author: dengxin.chen
 * @date: 2019-05-31 17:57
 * @description:
 */
public class SortTest {

    List<MuCondition> listSource = Arrays.asList(
            new MuCondition(10, "好", 30),
            new MuCondition(20, "不好好", 10),
            new MuCondition(30, "很好", 30),
            new MuCondition(30, "中评", 20),
            new MuCondition(30, "中评2", 20),
            new MuCondition(12, "很不好", 10)

                                                );

    @Test
    public void test() {
        boolean ag123 = StringUtils.isNumeric("AG123");
        String ttt = "";
        System.out.println(ttt.length());
        Map<Integer, List<MuCondition>> collect = listSource.stream().sorted(Comparator.comparing(MuCondition::getCount).reversed()).collect(Collectors.groupingBy(MuCondition::getLevel, LinkedHashMap::new, Collectors.toList()));
        List<MuCondition> collect1 = collect.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Test
    public void testHashcode() {
        HashCodeTest test1 = new HashCodeTest();
        test1.setName("xxx");
        test1.setTag(1);

        HashCodeTest test2 = new HashCodeTest();
        test2.setName("xxx");
        test2.setTag(1);

        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
    }
}
