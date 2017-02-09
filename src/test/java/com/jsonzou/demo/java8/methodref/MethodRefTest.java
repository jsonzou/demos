/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.methodref;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 方法引用
 * Created by v_zoupengfei on 2017/2/9.
 */
public class MethodRefTest {

    @Test
    public void contructTest(){
        // 第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数。
        Car car=Car.create(Car :: new);
        car.setName("CR-V");
        List<Car> cars= Arrays.asList(car);
        // 第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。
        cars.forEach(CarHandler::handle);
        // 第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
        cars.forEach(Car::toString);
        // 第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数
        cars.forEach( car::follow );

    }
}
