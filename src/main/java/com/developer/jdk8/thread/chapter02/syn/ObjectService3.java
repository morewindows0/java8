package com.developer.jdk8.thread.chapter02.syn;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author: dengxin.chen
 * @date: 2018/11/15 9:46
 * @description: 演示线程调用不确定性出现脏读的问题
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
