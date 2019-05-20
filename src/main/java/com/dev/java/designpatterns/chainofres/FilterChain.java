package com.dev.java.designpatterns.chainofres;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;

/**
 * @author: dengxin.chen
 * @date: 2019/5/20 15:04
 * @description:
 */
public class FilterChain implements ProcessFilter {

    private int pos = 0;

    private CoreTest coreTest;

    private List<ProcessFilter> filterList;

    public FilterChain(CoreTest coreTest) {
        this.coreTest = coreTest;
    }

    public void addFilter(ProcessFilter filter) {
        if (CollectionUtils.isEmpty(filterList)) {
            filterList = Lists.newArrayList();
        }
        filterList.add(filter);
    }

    @Override
    public void doFilter(Context context, FilterChain chain) {
        if (pos == filterList.size()) {
            coreTest.CoreMethod();
            return;
        }
        filterList.get(pos++).doFilter(context, chain);
    }
}
