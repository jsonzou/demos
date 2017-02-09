/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.guava.string;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class StringTest {
    @Test
    public void camelTest(){
        String camelString=CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,"A_BC123");
        System.out.println(camelString);
    }
    @Test
    public void charMatcherTest(){
        String anyString=CharMatcher.breakingWhitespace().collapseFrom("b \n , ; . aa \t ee \t cc  dd  b",'#');
        System.out.println(anyString);
        anyString=CharMatcher.whitespace().collapseFrom("b  aa  ee  cc  dd  b",'#');
        System.out.println(anyString);
        anyString=CharMatcher.anyOf("dd").collapseFrom("b  aa  ee  cc  dd  b",'#');
        System.out.println(anyString);
        anyString=CharMatcher.digit().collapseFrom("b  a2a  ee  4cc  dd 1 b",'#');
        System.out.println(anyString);
        anyString=CharMatcher.ascii().collapseFrom("b  a2a  ee  4cc  dd 1 b",'#');
        System.out.println(anyString);
        anyString=CharMatcher.javaLetter().collapseFrom("b  a2a $ _ ee  4cc  dd 1 b",'#');
        System.out.println(anyString);
        anyString=CharMatcher.none().collapseFrom("b  a2a $ _ ee  4cc  dd 1 b",'#');
        System.out.println(anyString);
    }
    @Test
    public void splitterTest(){
      List<String> splitString=  Splitter.on(",").trimResults().omitEmptyStrings().splitToList("a,b,c, d , ,e,");
      System.out.println(JSONObject.toJSONString(splitString));
      splitString=  Splitter.on(",").trimResults().splitToList("a,b,c, d , ,e,");
      System.out.println(JSONObject.toJSONString(splitString));
      splitString=  Splitter.on(",").splitToList("a,b,c, d , ,e,");
      System.out.println(JSONObject.toJSONString(splitString));

        splitString=  Splitter.on(Pattern.compile("\\d{2}")).splitToList("a1b12c2d  44   55 e  ");
        System.out.println(JSONObject.toJSONString(splitString));
    }

    @Test
    public void joinTest(){
        String joinString  = Joiner.on("#").skipNulls().join(new String[]{"Harry", null, "Ron", "Hermione"});
        System.out.println(joinString);

        joinString  = Joiner.on("#").join(new String[]{"Harry", "Ron", "Hermione"});
        System.out.println(joinString);

        joinString  = Joiner.on("\n").withKeyValueSeparator(":").join(ImmutableMap.of("name","json",
                "age","21",
                "hobby","zoo"));
        System.out.println(joinString);
    }
}
