/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.interfaceds;

import java.util.function.Supplier;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public interface Defaultable {
    default void notRequired(){
        System.out.println("default method");
    }
    static void staticMethod(){
        System.out.println("static method");
    }
    static Defaultable create(Supplier<Defaultable> supplier){
         return supplier.get();
    }
}
