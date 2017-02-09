/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.interfaceds;

import org.junit.Test;

/**
 * 接口支持默认方法、静态方法
 * Created by v_zoupengfei on 2017/2/9.
 */
public class DefaultableTest {
    @Test
    public void defaultTest(){
        Defaultable def=new DefaultableImpl();
        def.notRequired();
        Defaultable defOveried=new DefaultableOveriedImpl();
        defOveried.notRequired();
    }

    @Test
    public void staticTest(){
        Defaultable.staticMethod();
        Defaultable def=Defaultable.create(DefaultableImpl :: new);
        def.notRequired();
        Defaultable overied=Defaultable.create(DefaultableOveriedImpl :: new);
        overied.notRequired();
    }
}
