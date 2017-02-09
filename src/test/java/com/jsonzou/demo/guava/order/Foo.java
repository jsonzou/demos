/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.guava.order;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class Foo {
    private String sortedBy;
    private int notSortedBy;

    public Foo() {
    }

    public Foo(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    public String getSortedBy() {
        return sortedBy;
    }

    public void setSortedBy(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    public int getNotSortedBy() {
        return notSortedBy;
    }

    public void setNotSortedBy(int notSortedBy) {
        this.notSortedBy = notSortedBy;
    }
}
