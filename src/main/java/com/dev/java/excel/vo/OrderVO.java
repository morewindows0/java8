package com.dev.java.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: dengxin.chen
 * @date: 2018/12/14 10:19
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO extends BaseRowModel {

    @ExcelProperty(value = "序号", index = 0)
    private Long id;
    @ExcelProperty(value = "姓名", index = 1)
    private String name;

}
