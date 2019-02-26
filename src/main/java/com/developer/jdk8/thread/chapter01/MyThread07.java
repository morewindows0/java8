package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 14:15
 * @description:
 */
public class MyThread07 extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }


    public static void main(String[] args) {
        MyThread07 thread07 = new MyThread07();
        thread07.start();
        Mythread08 mythread08 = new Mythread08();
        mythread08.start();
    }
  /*username=b password=bb
    username=b password=aa
    出现的一种情况
    由于当username.equals("a")的时候线程暂停，导致username被赋值为b
    解决方式，使用synchronized修饰，进行同步
    */
}

class Mythread08 extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}

