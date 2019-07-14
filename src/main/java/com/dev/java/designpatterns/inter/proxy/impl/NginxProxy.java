package com.dev.java.designpatterns.inter.proxy.impl;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 11:49
 * @description:使用代理模式
 */
public class NginxProxy implements Server {

    private Server server;

    public NginxProxy(Server server) {
        this.server = server;
    }

    @Override
    public String getPageTitle(String url) {
        return server.getPageTitle(url);
    }
}
