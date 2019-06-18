package com.sdttttt.github.netty.springframework.boot.starter.autoconfiguration;

import com.sdttttt.github.netty.springframework.boot.starter.configure.NettyConfigurationBuilder;
import com.sdttttt.github.netty.springframework.boot.starter.configure.NettyConfigureProperties;
import com.sdttttt.github.netty.springframework.boot.starter.service.NettyService;
import com.sdttttt.github.netty.springframework.boot.starter.service.done.NettyServiceDefault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnClass(NettyService.class)
@EnableConfigurationProperties(NettyConfigureProperties.class)
@Configuration
public class NettyAutoConfiguration{


    @Autowired(required = false)
    private NettyConfigurationBuilder builder;

    @Autowired()
    private NettyConfigureProperties nettyConfigureProperties;

    @Bean
    @ConditionalOnMissingBean(NettyService.class)
    public NettyService nettyService(){
        if(builder != null) return new NettyServiceDefault(builder.builder());
        return new NettyServiceDefault(nettyConfigureProperties);
    }

}