package com.dev.java.test.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dengxin.chen
 * @date: 2019-07-29 16:23
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class POI extends BaseRowModel {

    @ExcelProperty(value = "id", index = 0)
    private String id;

    @ExcelProperty(value = "名称", index = 1)
    private String name;

   /* @ExcelProperty(value = "省", index = 2)
    private String province;*/

    @ExcelProperty(value = "市", index = 3)
    private String city;

  /*  @ExcelProperty(value = "地址", index = 4)
    private String address;

    @ExcelProperty(value = "经度", index = 5)
    private Double lng;

    @ExcelProperty(value = "纬度", index = 6)
    private Double lat;*/
   /*
    @ExcelProperty(value = "道路类型", index = 7)
    private String roadType;

    @ExcelProperty(value = "道路编号", index = 8)
    private String roadNo;*/

   @ExcelProperty(value = "品牌",index = 2)
   private String brand;

    @ExcelProperty(value = "类型",index = 4)
    private String type;

    @ExcelProperty(value = "分数",index = 5)
    private String score;
}
