package com.developer.jdk8.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/14 14:55
 * @description:用非this对象作为锁
 */
public class ObjectService1 {

    private String userName;
    private String passWord;

//    private String anyString = new String();

    public void setUserNameAndPassword(String userName, String passWord) {
        try {
            String anyString = new String();
            synchronized (anyString) {
                System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");
                this.userName = userName;
                Thread.sleep(1000);
                this.passWord = passWord;
                System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
