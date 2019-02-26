package com.developer.jdk8.test;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dengxin.chen
 * @date: 2019/1/8 17:26
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GasGroupVO implements Serializable {

    /**
     * 油站分组id
     */
    private Long id;

    /**
     * 油站分组名
     */
    private String name;

    /**
     * 加油站id 195期直接给固定油站发送消息，不进行审核
     */
    private Long gasStationId;
}
