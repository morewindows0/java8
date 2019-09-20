package com.dev.java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengxin.chen
 * @date: 2019-09-16 10:00
 * @description:
 */
public class CollectionSummary {

    public static void main(String[] args) {

        ArrayListTest();
    }

    private static void ArrayListTest() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(null);
        arrayList.add(null);
        System.out.println("ArrayList:" + arrayList);
    }

}
