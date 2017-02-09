/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.Test;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class Base64Test {
    @Test
    public void test(){
        final String text = "Base64 finally in Java 8!";

        final String encoded = Base64
                .getEncoder()
                .encodeToString( text.getBytes( StandardCharsets.UTF_8 ) );
        System.out.println( encoded );

        final String decoded = new String(
                Base64.getDecoder().decode( encoded ),
                StandardCharsets.UTF_8 );
        System.out.println( decoded );
    }
}
