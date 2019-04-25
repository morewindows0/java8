package com.dev.java.designpatterns.inter.simplefactory.impl;


import com.dev.java.designpatterns.inter.simplefactory.Login;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 15:33
 * @description:口令登录实现登录接口
 */
public class PasswordLoginImpl implements Login {
    @Override
    public boolean verify(String username, String password) {
        if ("test".equals(username) && "123456".equals(password)) {
            return true;
        }
        return false;
    }
}
