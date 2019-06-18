package com.sdttttt.github.netty.springframework.boot.starter.configure;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ServerChannel;

public class NettyConfiguration{

    private int port;

    private Integer back_log;

    private Class<? extends ServerChannel> channel;

    private Class<? extends ChannelHandler> handler;


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Integer getBack_log() {
        return back_log;
    }

    public void setBack_log(Integer back_log) {
        this.back_log = back_log;
    }

    public Class<? extends ServerChannel> getChannel() {
        return channel;
    }

    public void setChannel(Class<? extends ServerChannel> channel) {
        this.channel = channel;
    }

    public Class<? extends ChannelHandler> getHandler() {
        return handler;
    }

    public void setHandler(Class<? extends ChannelHandler> handler) {
        this.handler = handler;
    }

    

}