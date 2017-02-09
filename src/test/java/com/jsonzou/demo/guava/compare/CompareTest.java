/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.guava.compare;

import org.junit.Test;

import com.google.common.collect.ComparisonChain;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class CompareTest {
    /**
     * 1,0,-1
     * 返回第一个不相等的值中断 -1/1
     */
    @Test
    public void compareTest(){
      int result= ComparisonChain.start().compare(1,1).result();
      System.out.println(result);
      result= ComparisonChain.start().compare(1,1).compare("1","3").compare("1","3").result();
      System.out.println(result);
    }
}
