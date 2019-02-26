package com.developer.jdk8.designpatterns.inter.factorymethod.impl;

import com.developer.jdk8.designpatterns.factorymethod.ExportFinancialHtmlFile;
import com.developer.jdk8.designpatterns.factorymethod.ExportStandardHtmlFile;
import com.developer.jdk8.designpatterns.inter.factorymethod.ExportFactory;
import com.developer.jdk8.designpatterns.inter.factorymethod.ExportFile;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 16:35
 * @description: 导出Html工厂
 */
public class ExportHtmlFactory implements ExportFactory {
    @Override
    public ExportFile factory(String type) {
        if ("standard".equals(type)) {
            return new ExportStandardHtmlFile();
        } else if ("financial".equals(type)) {
            return new ExportFinancialHtmlFile();
        } else {
            throw new RuntimeException("未找到对应导出对象");
        }
    }
}
