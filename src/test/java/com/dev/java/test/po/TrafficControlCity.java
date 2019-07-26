/*
 *  Copyright 2014-2018 hcb, Inc.
 *
 */

package com.dev.java.test.po;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <br />
 *
 * @author dengxin.chen
 * @date 2019-7-25 10:43:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrafficControlCity {

    private static final long serialVersionUID = 1L;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 城市编码
     */
    private String adcode;

    private Long id;
    private Date createTime;
    private Date editTime;
    private Integer isDelete = 0;

}
