package com.dev.java.sort;

/**
 * @author: dengxin.chen
 * @date: 2019/2/19 15:56
 * @description:
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arry = {10, 9, 1, 2, 10};
        insertsort(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }

    public static int[] insertsort(int[] arry) {
        for (int i = 1; i < arry.length; i++) {
            int inserted = arry[i];
            int j = i - 1;
            for (; j >= 0 && arry[j] > inserted; j--) {
                arry[j + 1] = arry[j];
            }
            arry[j + 1] = inserted;
        }
        return arry;
    }
}
