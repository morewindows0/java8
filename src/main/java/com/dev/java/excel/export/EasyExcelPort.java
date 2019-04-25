package com.dev.java.excel.export;

import com.dev.java.excel.vo.OrderVO;

/**
 * @author: dengxin.chen
 * @date: 2018/12/14 16:13
 * @description: 使用阿里excel导出
 */
public class EasyExcelPort {

    public static void main(String[] args) {

    }

    public static void export() {
        OrderVO vo = OrderVO.builder().id(1L).name("test").build();
    }
}
