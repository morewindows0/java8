package com.dev.java.designpatterns.factorymethod;

import com.dev.java.designpatterns.inter.factorymethod.ExportFile;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 16:38
 * @description:
 */
public class ExportFinancialHtmlFile implements ExportFile {
    @Override
    public boolean export(String data) {

        System.out.println("导出财务版html文件");
        return true;

    }
}
