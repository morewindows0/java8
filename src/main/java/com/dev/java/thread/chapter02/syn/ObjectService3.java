package com.dev.java.thread.chapter02.syn;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author: developer
 * @date: 2019/5/6 22:24
 * @description:
 */

public class ObjectService3 {
    public MyOneList addServiceMethod(MyOneList list, String data) {
        try {
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);//模拟从远程花费2秒取回数据
                    list.add(data);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

class MyOneList {

    private List list = Lists.newArrayList();

    public synchronized void add(String data) {
        list.add(data);
    }

    public synchronized int getSize() {
        return list.size();
    }

}
