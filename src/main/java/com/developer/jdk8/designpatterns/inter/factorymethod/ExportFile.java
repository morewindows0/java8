package com.developer.jdk8.designpatterns.inter.factorymethod;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 16:28
 * @description: 导出文件接口，也相当于一个工厂,在具体实现对象中又实现了该接口，从而产生不同的对象
 */
public interface ExportFile {
    /**
     * 导出功能
     *
     * @param data
     * @return
     */
    boolean export(String data);
}
