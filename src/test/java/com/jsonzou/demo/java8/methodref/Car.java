/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.methodref;

import java.util.function.Supplier;

public class Car {
    private String name;

    public Car() {
    }

    public Car(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        System.out.println("toString:"+this.getName());
        return this.getName();
    }

    public static Car create(final Supplier< Car > supplier ) {
        System.out.println("create.");
        return supplier.get();
    }              
         

    public void follow( final Car another ) {
        System.out.println( "Follow:" + another.getName());
    }

}