package com.developer.jdk8.excel.export;

import com.developer.jdk8.excel.vo.OrderVO;

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
