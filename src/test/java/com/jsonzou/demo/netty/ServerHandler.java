/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by v_zoupengfei on 2017/2/27.
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {
   private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        // 输出接收到的数据
        System.out.println("客户端:" +msg);
        try {
            String line = br.readLine();
            System.out.println("服务端:" + line);
            ctx.channel().writeAndFlush(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 向客户端发送数据
       // ctx.channel().writeAndFlush(line);
    }

    /**
     *
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("Server channelActive");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println("Server channelInactive");
    }

}
