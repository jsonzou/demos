/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.guava.order;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class OrderTest {
    /**
     * 正序、倒序排
     */
    @Test
    public void orderTest(){
        List<Foo> foos=Lists.newArrayList(new Foo("d"),new Foo("e"),new Foo("a"),new Foo("c"),new Foo("b"),null,new Foo
                (null));

        Function<Foo, String> orderByFunction=new Function<Foo, String>() {
            public String apply(Foo input) {
                return input==null?null: input.getSortedBy();
            }
        };

        // 正序
        List<Foo> orderingFoo= Ordering.natural().nullsFirst().onResultOf(orderByFunction).sortedCopy(foos);
        System.out.println(JSONObject.toJSONString(orderingFoo,true));

        // 倒序
        orderingFoo= Ordering.natural().reverse().nullsLast().onResultOf(orderByFunction).sortedCopy(foos);
        System.out.println(JSONObject.toJSONString(orderingFoo,true));

    }
}
