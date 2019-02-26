package com.developer.jdk8.thread.chapter01;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 14:15
 * @description: 模拟登录组件
 */
public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    public static synchronized void doPost(String username, String password) {
        try {
            usernameRef = username;
            if ("a".equals(username)) {
                Thread.sleep(3000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + " password=" + passwordRef);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
