package com.ruoyi.framework.config;

import java.util.TimeZone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 属性exposeProxy=true表示通过AopContext可以在本类中获取代理对象
 * 属性proxyTargetClass=true表示使用CGLIB方式创建代理对象
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.ruoyi.**.mapper")
public class ApplicationConfig {
    /**
     * 时区配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}
