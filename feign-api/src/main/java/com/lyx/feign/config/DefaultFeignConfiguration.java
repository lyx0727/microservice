package com.lyx.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLever(){
        return Logger.Level.BASIC;
    }
}
