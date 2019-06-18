package com.sdttttt.github.netty.springframework.boot.starter.configure;

import io.netty.channel.ChannelHandler;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyConfigurationBuilder{

    private NettyConfiguration nettyConfiguration;

    public NettyConfigurationBuilder newBuilder(){
        
        nettyConfiguration = new NettyConfiguration();
        
        return this;

    }

    public NettyConfigurationBuilder setBuildPort(int port){
        nettyConfiguration.setPort(port);

        return this;
    }

    public NettyConfigurationBuilder setBuildHandler(Class<? extends ChannelHandler> handler){
        nettyConfiguration.setHandler(handler);
        return this;
    }

    public NettyConfigurationBuilder buildNioServerSocketChannel(){
        nettyConfiguration.setChannel(NioServerSocketChannel.class);
        return this;
    }

    public NettyConfiguration builder(){
        return nettyConfiguration;
    }
}