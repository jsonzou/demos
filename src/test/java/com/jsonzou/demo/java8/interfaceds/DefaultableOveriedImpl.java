/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.interfaceds;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class DefaultableOveriedImpl implements Defaultable {
    @Override
    public void notRequired() {
        System.out.println("default overied method");
    }
}
