/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.java8.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.jsonzou.demo.utils.ResourceUtil;

/**
 * Created by v_zoupengfei on 2017/2/9.
 */
public class StreamTest {
    private enum Status {
        OPEN, CLOSED
    };

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

    @Test
    public void testDataStream(){
        final List< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 2 ),
                new Task( Status.OPEN, 3 ),
                new Task( Status.CLOSED, 5 )
        );

       int openPoint= tasks.stream()
                .filter(task  -> task.getStatus()== Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println("openPoint:"+openPoint);


       int totalPoint= tasks.stream().parallel()
                .mapToInt(Task:: getPoints)
                .reduce(0,Integer::sum);
        System.out.println("totalPoint:"+totalPoint);


       Map<Status,List<Task>> groupByStatus=tasks.stream()
               .collect(
                       Collectors.groupingBy(Task :: getStatus)
               );
       System.out.println(groupByStatus);


       List<String> collect= tasks.stream()
                .mapToInt(Task::getPoints)
                .asDoubleStream()
                .map(point -> point/totalPoint)
                .boxed()
                .mapToLong(point -> (long)(point *100))
                .mapToObj(w -> w+"%")
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void testFileStream() throws IOException {
        File file= ResourceUtil.getFile("classpath:stream.text");
        Path path=file.toPath();
        Files.lines(path, StandardCharsets.UTF_8)
             .onClose(()-> System.out.println("Done."))
             .forEach(System.out::println);

       List<String> lines= Files.lines(path, StandardCharsets.UTF_8)
               .collect(Collectors.toList());
        System.out.println(JSON.toJSON(lines));
    }
}
