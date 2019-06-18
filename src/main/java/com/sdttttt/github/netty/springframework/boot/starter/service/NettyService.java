package com.sdttttt.github.netty.springframework.boot.starter.service;

import com.sdttttt.github.netty.springframework.boot.starter.configure.NettyConfiguration;


public abstract class NettyService {

    protected NettyConfiguration config;

    public void setNettyConfigure(NettyConfiguration nettyConfigure) {
        this.config = nettyConfigure;
    }

    public NettyService(NettyConfiguration config){
        this.config = config;
    }

    public abstract void start();

}