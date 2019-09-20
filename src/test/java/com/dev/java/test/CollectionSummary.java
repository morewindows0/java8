package com.dev.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

/**
 * @author: dengxin.chen
 * @date: 2019-09-20 09:51
 * @description:
 */
public class CollectionSummary {

    public static void main(String[] args) {

    }

    @Test
    public void ArrayListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(null);
        System.out.println(list);
    }

    @Test
    public void LinkedListTest() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(null);
        System.out.println(list);
    }

    @Test
    public void copyOnWriteArrayListTest() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(1);
        list.add(null);
        System.out.println(list);
    }

    @Test
    public void hashMapTest() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(null, null);
        map.put(1, 1);
        map.put(1, null);
        map.put(null, 1);
        map.put(1, 1);
        System.out.println(map);
    }

    @Test
    public void hashTableTest() {
        Map<Integer, Integer> map = new Hashtable<>();
//        map.put(null, null);
        map.put(1, 1);
//        map.put(1, null);
//        map.put(null, 1);
        map.put(1, 1);
        System.out.println(map);
    }

    @Test
    public void linkedHashMapTest() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(null, null);
        map.put(1, 1);
        map.put(1, 1);
        System.out.println(map);
    }

    @Test
    public void weakHashMapTest() {
        Map<Integer, Integer> map = new WeakHashMap<>();
        map.put(null, null);
        map.put(1, 1);
        map.put(1, 1);
        System.out.println(map);

    }
}
