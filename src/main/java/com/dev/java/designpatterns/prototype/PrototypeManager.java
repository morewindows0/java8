package com.dev.java.designpatterns.prototype;

import java.util.Map;
import java.util.Objects;

import com.dev.java.designpatterns.inter.prototype.PrototypeRegister;
import com.google.common.collect.Maps;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 11:20
 * @description:原型模式-登记形式的原型管理器
 */
public class PrototypeManager {

    /**
     * 用来记录原型的编号和原型实例的对应关系
     */
    private static Map<String, PrototypeRegister> map = Maps.newHashMap();

    private PrototypeManager() {
    }

    /**
     * 向原型管理器里面添加或修改某个原型注册
     *
     * @param prototypeId
     * @param prototype
     */
    public synchronized static void setPrototype(String prototypeId, PrototypeRegister prototype) {
        map.put(prototypeId, prototype);
    }


    /**
     * 从原型管理器里面删除某个原型
     *
     * @param prototypeId
     */
    public synchronized static void removePrototype(String prototypeId) {
        map.remove(prototypeId);
    }


    /**
     * 获取原型实例
     *
     * @param prototypeId
     * @return
     */
    public synchronized static PrototypeRegister getPrototype(String prototypeId) {
        PrototypeRegister prototype = map.get(prototypeId);
        if (Objects.isNull(prototype)) {
            throw new RuntimeException("原型已经被销毁或未注册");
        }
        return prototype;
    }

}
