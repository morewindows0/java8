package com.dev.java.sort;

import java.util.Objects;

/**
 * @author: dengxin.chen
 * @date: 2019/2/19 11:45
 * @description: 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arry = {10, 9, 1, 2, 10};
        selectsort(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }

    public static int[] selectsort(int[] arry) {
        if (Objects.isNull(arry) || arry.length == 0) {
            return null;
        }
        int size = arry.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arry[minIndex] > arry[j]) {
                    minIndex = j;
                }
            }
            int tmp = arry[minIndex];
            arry[minIndex] = arry[i];
            arry[i] = tmp;
        }
        return arry;
    }
}
