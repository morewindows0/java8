package com.developer.jdk8.test;

import java.util.Optional;

import org.junit.Test;

import com.developer.jdk8.domain.UserDomain;

/**
 * @author: dengxin.chen
 * @date: 2018/9/16 17:39
 * @description:
 */
public class OptionalTest {

    /**
     * Optional:
     * Optional.ofNullable(T) 若T不为null，则创建Optional，否则创建空实例
     */
    @Test
    public void optionalTest() {

//        Optional<UserDomain> td = Optional.of(new UserDomain("test", "男", 123));
        Optional<UserDomain> td = Optional.ofNullable(new UserDomain("test", "男", 33));

        if (td.isPresent()) {
            System.out.println(td.get());
        }

    }
}
