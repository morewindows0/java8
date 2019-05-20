package com.dev.java.designpatterns.chainofres;

import lombok.Builder;
import lombok.Data;

/**
 * @author: dengxin.chen
 * @date: 2019/5/20 15:03
 * @description:
 */
@Data
@Builder
public class Context {

    private boolean driver;

    private boolean eat;

    private boolean drink;
}
