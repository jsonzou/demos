/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.guava.collect;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class Person {
    private int id;
    private String name;
    private String hobby;
    private int sex;
    private int age;

    public Person() {
    }

    public Person(int id, String name, String hobby, int sex, int age) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
