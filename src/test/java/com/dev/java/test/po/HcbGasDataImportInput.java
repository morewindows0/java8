package com.dev.java.test.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dengxin.chen
 * @date: 2019-07-01 14:24
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HcbGasDataImportInput extends BaseRowModel {

    @ExcelProperty(value = "加油站id", index = 0)
    private String id;

   /* @ExcelProperty(value = "加油站名称", index = 1)
    private String name;

    @ExcelProperty(value = "百度经度", index = 2)
    private Double baiduLng;

    @ExcelProperty(value = "百度纬度", index = 3)
    private Double baiduLat;

    @ExcelProperty(value = "是否合作", index = 4)
    private Integer cooperateStatus;

    @ExcelProperty(value = "品牌编码", index = 5)
    private String brandCode;

    @ExcelProperty(value = "省", index = 6)
    private Integer province;*/

   /* @ExcelProperty(value = "市", index = 7)
    private Integer city;*/

    @ExcelProperty(value = "区", index = 1)
    private Integer country;

    /*@ExcelProperty(value = "地址", index = 9)
    private String address;

    *//**
     * 油站来源;货车帮油站：1 （来源货车帮）;高德油站：2来源高德
     *//*
    @ExcelProperty(value = "油站来源", index = 10)
    private Integer source;

    @ExcelProperty(value = "油站类型", index = 11)
    private String type;*/

    /**
     * 高德经度
     */
    private Double gdLng;

    /**
     * 高德维度
     */
    private Double gdLat;

    /**
     * geo_hash
     */
    private String geoHash;
}
