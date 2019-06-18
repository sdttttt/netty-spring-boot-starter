package com.sdttttt.github.netty.springframework.boot.starter.service.done;

import com.sdttttt.github.netty.springframework.boot.starter.configure.NettyConfiguration;
import com.sdttttt.github.netty.springframework.boot.starter.service.NettyService;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class NettyServiceDefault extends NettyService {

    public NettyServiceDefault(NettyConfiguration nettyConfigure){
        super(nettyConfigure);
    }

    public void start(){
        
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
      
            bootstrap.group(boss, worker)
                .channel(config.getChannel())
                .option(ChannelOption.SO_BACKLOG, config.getBack_log())
                .childHandler(config.getHandler().newInstance());

            ChannelFuture future = bootstrap.bind(config.getPort()).sync();
        
            future.channel().close().sync();

        }catch(InterruptedException exception){
            
            exception.printStackTrace();
        
        }catch(InstantiationException exception){
            
            exception.printStackTrace();
            System.out.println("在创建您的Handler实例的时候出现了错误");
        
        }catch(IllegalAccessException exception){
        
            exception.printStackTrace();
            System.out.println("在创建您的Handler实例的时候出现了错误");
        
        }finally{
        
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        
        }
    }


}