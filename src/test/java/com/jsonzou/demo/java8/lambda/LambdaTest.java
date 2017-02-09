/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.lambda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * lambda表达式
 * Created by v_zoupengfei on 2017/2/9.
 */
public class LambdaTest {
    @Test
    public void forEachTest(){
        Arrays.asList("a","b","c").forEach(e -> System.out.println(e));
    }
    @Test
    public void sortTest(){
        List<String> sortList=Arrays.asList("b","c","a");
        sortList.forEach(e -> System.out.print(e));
        System.out.println();
        sortList.sort((e1,e2) -> e1.compareTo(e2));
        sortList.forEach(e -> System.out.print(e));
    }
}
