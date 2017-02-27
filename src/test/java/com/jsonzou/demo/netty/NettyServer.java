/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Created by v_zoupengfei on 2017/2/27.
 */
public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap=new ServerBootstrap();

        EventLoopGroup boss=new NioEventLoopGroup();
        EventLoopGroup worker =new NioEventLoopGroup();
        try {
            serverBootstrap.group(boss,worker);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new StringEncoder());
                    ch.pipeline().addLast(new ServerHandler());
                }
            });

            serverBootstrap.option(ChannelOption.SO_BACKLOG, 2048);
            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true);

            ChannelFuture future=serverBootstrap.bind("127.0.0.1",9000);
            Channel channel=future.channel();
            System.out.println("服务端已启动...");
            channel.closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
