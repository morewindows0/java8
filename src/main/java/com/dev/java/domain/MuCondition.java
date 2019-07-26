package com.dev.java.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dengxin.chen
 * @date: 2019-05-31 17:56
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MuCondition {

    private Integer count;
    private String name;
    private Integer level;
}
