package com.developer.jdk8.thread.chapter03.waittest;

/**
 * @author: dengxin.chen
 * @date: 2018/11/19 15:56
 * @description:利用wait/notify实现有序备份
 */
public class DBTools {
    private volatile boolean previsA = false;

    public synchronized void backupA() {
        try {
            //注意理解wait的条件
            while (previsA == true) {
                this.wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("★★★★★");
            }
            previsA = true;
            this.notifyAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void backupB() {
        try {
            while (previsA == false) {
                this.wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("☆☆☆☆☆");
            }
            previsA = false;
            this.notifyAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TestRun {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 20; i++) {
            Thread backupa = new Thread(() -> dbTools.backupA());
            backupa.start();
            Thread backupb = new Thread(() -> dbTools.backupB());
            backupb.start();
        }
    }
}
