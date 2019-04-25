package com.dev.java.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dengxin.chen
 * @date: 2019/1/24 11:00
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultLabel {

    private String name;
    private Long count;
}
