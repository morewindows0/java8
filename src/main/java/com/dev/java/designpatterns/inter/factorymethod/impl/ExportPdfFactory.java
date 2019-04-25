package com.dev.java.designpatterns.inter.factorymethod.impl;

import com.dev.java.designpatterns.factorymethod.ExportFinancialPdfFile;
import com.dev.java.designpatterns.factorymethod.ExportStandardPdfFile;
import com.dev.java.designpatterns.inter.factorymethod.ExportFactory;
import com.dev.java.designpatterns.inter.factorymethod.ExportFile;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 16:41
 * @description:
 */
public class ExportPdfFactory implements ExportFactory {
    @Override
    public ExportFile factory(String type) {
        if ("standard".equals(type)) {
            return new ExportStandardPdfFile();
        } else if ("financial".equals(type)) {
            return new ExportFinancialPdfFile();
        } else {
            throw new RuntimeException("未找到对应导出对象");
        }

    }
}
