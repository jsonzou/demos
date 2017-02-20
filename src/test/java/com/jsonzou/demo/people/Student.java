/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.people;

/**
 * Created by v_zoupengfei on 2017/2/17.
 */
public class Student extends People {
    static{
        System.out.println("子类的静态块");
    }
    {
        System.out.println("子类的初始化块");
    }
    public Student(){
        System.out.println("子类的构造方法");
    }
}
