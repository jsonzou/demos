/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.people;

/**
 * Created by v_zoupengfei on 2017/2/17.
 */
public class People {
    static{
        System.out.println("父类的静态块");
    }
    {
        System.out.println("父类的初始化块");
    }
    public People(){
        System.out.println("父类的构造方法");
    }
}
