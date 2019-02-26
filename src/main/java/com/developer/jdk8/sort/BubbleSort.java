package com.developer.jdk8.sort;

/**
 * @author: dengxin.chen
 * @date: 2019/2/19 16:49
 * @description:冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arry = {10, 9, 1, 2, 10};
        bubbleSort(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }

    public static int[] bubbleSort(int[] arry) {
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = 0; j < arry.length - 1 - i; j++) {
                if (arry[j] > arry[j + 1]) {
                    int tmp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = tmp;
                }
            }
        }
        return arry;
    }
}
