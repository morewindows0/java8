package com.dev.java.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dengxin.chen
 * @date: 2019-07-17 19:51
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityLngLat {

    private Double lng;
    private Double lat;

}
