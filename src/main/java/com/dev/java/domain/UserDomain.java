package com.dev.java.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: developer
 * @date: 2018/9/11 22:36
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDomain implements Serializable {

    private String name;
    private String gender;
    private Integer age;
}
