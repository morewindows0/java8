package com.developer.jdk8.designpatterns.factorymethod;

import com.developer.jdk8.designpatterns.inter.factorymethod.ExportFile;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 16:43
 * @description:
 */
public class ExportFinancialPdfFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("导出财务版标准pdf文件");
        return true;
    }
}
