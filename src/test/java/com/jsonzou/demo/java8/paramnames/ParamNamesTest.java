/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.paramnames;

import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.junit.Test;

/**
 * 方法的参数名字保留进字节码中
 * Created by v_zoupengfei on 2017/2/9.
 */
public class ParamNamesTest {
    public void aMethod(String param1,String param2){

    }
    @Test
    public void test() throws NoSuchMethodException {
        Parameter[] parameters= ParamNamesTest.class.getMethod("aMethod",String.class, String.class ).getParameters();
        Arrays.asList(parameters).forEach(p -> System.out.println(p.getName()));
    }
}
