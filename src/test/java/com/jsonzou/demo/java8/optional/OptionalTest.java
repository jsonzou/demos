/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.optional;

import java.util.Optional;

import org.junit.Test;

/**
 * 空指针异常处理，思路来自google 哦
 * Created by v_zoupengfei on 2017/2/9.
 */
public class OptionalTest {
    @Test
    public void test(){
        Optional< String > fullName = Optional.ofNullable( null );
        System.out.println( "Full Name set null"   );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey anonymous user !" ) );

        System.out.println("---------------------------我是华丽的分割线---------------------------------------");

        fullName = Optional.ofNullable( "Json Zou" );
        System.out.println( "Full Name set Json Zou"   );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey anonymous user !" ) );

    }
}
