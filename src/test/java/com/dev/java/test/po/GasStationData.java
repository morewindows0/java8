package com.dev.java.test.po;

import lombok.Data;

/**
 * @author: dengxin.chen
 * @date: 2019-07-03 11:27
 * @description:
 */
@Data
public class GasStationData {

    private String name;

    private String poiid;

    private String district;

    private String category;

    private String lnglat;

    private double lng;

    private double lat;
}
