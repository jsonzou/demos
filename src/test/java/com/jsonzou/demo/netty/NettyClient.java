/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by v_zoupengfei on 2017/2/27.
 */
public class NettyClient {
    public static void main(String[] args) {
        Bootstrap bootstrap=new Bootstrap();
        EventLoopGroup worker=new NioEventLoopGroup();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(worker);
        bootstrap.handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(new StringEncoder());
                channel.pipeline().addLast(new StringDecoder());
                channel.pipeline().addLast(new ClientHandler());
            }
        });
        ChannelFuture future = bootstrap.connect("127.0.0.1", 9000);
        System.out.println("客户端已启动...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String line = br.readLine();
                System.out.println("客户端:" + line);
                future.channel().writeAndFlush(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
