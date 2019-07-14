package com.dev.java.designpatterns.inter.proxy.impl;



/**
 * @author: dengxin.chen
 * @date: 2018/11/6 11:48
 * @description:新浪服务器
 */
public class SinaServer implements Server {
    @Override
    public String getPageTitle(String url) {
        return "新浪首页";
    }
}
