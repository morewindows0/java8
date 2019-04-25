package com.dev.java.test;

import org.junit.Test;

import com.dev.java.designpatterns.cglibproxy.DaoAnotherProxy;
import com.dev.java.designpatterns.cglibproxy.DaoFilter;
import com.dev.java.designpatterns.cglibproxy.DaoProxy;
import com.dev.java.designpatterns.inter.cglibproxy.Dao;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 15:21
 * @description:Cglib测试
 */
public class CglibTest {

    /**
     * Cglib使用测试
     */
    @Test
    public void cglibTest() {
        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);

        Dao dao = (Dao) enhancer.create();

        dao.update();
        dao.select();
    }


    /**
     * 具体方法拦截cglib
     */
    @Test
    public void cglibTest1() {

        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();
        DaoProxy daoProxy = new DaoProxy();
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{daoProxy, daoAnotherProxy, NoOp.INSTANCE});

        //设置回调方法的顺序“select”返回为0，则对应callbacks中0位置的daoProxy
        enhancer.setCallbackFilter(new DaoFilter());

        Dao dao = (Dao) enhancer.create();

        //这里首先调用的是select方法
        dao.select();
        dao.update();
    }
}
