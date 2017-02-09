/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.guava.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class CollectTest {
    @Test
    public void collectNewTest(){
        List<String> aList=Lists.newArrayList();
        Set<String> aSet= Sets.newHashSet();
        Map<String,String> aMap=Maps.newHashMap();
    }


    @Test
    public void collectInstanceTest(){
        List<String> aList=Lists.newArrayList("a1","b1","c1");
        Set<String> aSet= Sets.newHashSet("a2","b2","c2");
        Map<String,String> aMap= ImmutableMap.of("k1","v1","k2","v2");
        System.out.println(JSON.toJSONString(aList));
        System.out.println(JSON.toJSONString(aSet));
        System.out.println(JSON.toJSONString(aMap));
        aList= ImmutableList.of("a3","b3","c3");
        aSet= ImmutableSet.of("a4","b4","c4");
        System.out.println(JSON.toJSONString(aList));
        System.out.println(JSON.toJSONString(aSet));

    }

    @Test
    public void collections2Test(){
        List<Person> personList=Lists.newArrayList(new Person(1,  "a", "46546", 1, 20),
                new Person(2,  "ab", "46546", 0, 30),
                new Person(3,  "abc", "46546", 1, 25),
                new Person(4,  "aef", "46546", 1, 50),
                new Person(5,  "ade", "46546",1, 27),
                new Person(6,  "acc", "46546", 1, 29),
                new Person(7,  "add", "46546",1, 33));

        Collection<Person> personListFiltered= Collections2.filter(personList,new Predicate<Person>() {
            @Override
            public boolean apply( Person input) {
                return input.getSex()==0;
            }
        });
        System.out.println(JSON.toJSONString(personListFiltered));
    }

}
