package com.dev.java.test;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import com.google.common.collect.Maps;

/**
 * @author: dengxin.chen
 * @date: 2019-08-08 10:58
 * @description:
 */
public class InitTest {

    public static void main(String[] args) throws Exception {
//        new Father();
       /* System.out.println(GCD(2, 2));
        System.out.println(get_lcm(2, 2));*/
//        Map<Integer, Integer> map = new Hashtable<>();
//        map.put(null,1);
       /* BigDecimal bd=new BigDecimal("5.6");
        System.out.println(bd.toPlainString());*/
         int i1 = 12 << 16;
        System.out.println(i1+2);
        ConcurrentHashMap<Integer, Integer> testMap = new ConcurrentHashMap<>();
       /* for (int i = 0; i < 16; i++) {
            testMap.put(i, i + 1);
        }*/
        Map<Integer, Integer> tttMap = Maps.newHashMap();
        tttMap.put(90, 9);
        testMap.putAll(tttMap);
        final int i = tableSizeFor(16 + (16 >>> 1) + 1);
        LinkedList linkedList = new LinkedList();
        linkedList.add(null);
        Map<Integer, Integer> maps = new TreeMap<>();
        Integer a = new Integer(1);
        maps.put(1, null);
        maps.put(a, 1);
        a = null;
        System.gc();
        /*List<String> strings1 = Splitter.on(",").splitToList("1,2,3").stream().filter(e -> !e.equals("2")).collect(Collectors.toList());

        Date yyyyMMddHHmmss = parseDate("1566748800", "yyyyMMddHHmmss");

        List<Integer> tt = Lists.newArrayList();
        tt.add(1);
        tt.add(2);
        tt.add(3);
        tt.add(3);
        tt.add(4);
        tt.add(4);

        Integer[] aaa = {1, 1};
        final List<List<Integer>> partition = Lists.partition(Arrays.asList(aaa), 1);

        for (Integer integer : tt) {
            if (integer == 3) {
                tt.remove(integer);
            }
        }
        Iterator<Integer> iterator = tt.iterator();*/
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(4);
    }


    public static Date parseDate(String inputString, String dateFormat) throws ParseException {
        if (StringUtils.isEmpty(inputString)) {
            return null;
        }
        FastDateFormat fastDateFormat = FastDateFormat.getInstance(dateFormat);
        try {
            // 时间戳形式
            if (StringUtils.isNumeric(inputString)) {
                String dateTimeStamp = fastDateFormat.format(Long.valueOf(inputString));
                inputString = dateTimeStamp;
            }
            return fastDateFormat.parse(inputString);
        } catch (Exception e) {
            throw e;
        }
    }

    // 最大公约数
    public static Integer GCD(Integer m, Integer n) {

        Integer result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    // 最小公倍数
    public static int get_lcm(int m, int n) {
        return m * n / GCD(m, n);
    }

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static final int HASH_BITS = 0x7fffffff;

    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

}

class Father {
    public int j = 0;
    public static Father father = new Father();

    static {
        System.out.println("Father static block");
    }

    {
        System.out.println("Father not static block");
    }

    public Father() {
        System.out.println("Father Constructor");
    }
}
