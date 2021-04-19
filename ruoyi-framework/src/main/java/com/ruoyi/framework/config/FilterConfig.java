package com.ruoyi.framework.config;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.DispatcherType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ruoyi.common.filter.RepeatableFilter;
import com.ruoyi.common.filter.XssFilter;
import com.ruoyi.common.utils.StringUtils;

/**
 * 配置可重复读取输入流过滤器和防止XSS攻击过滤器
 */
@Configuration
public class FilterConfig {
    @Value("${xss.enabled}")
    private String enabled;

    @Value("${xss.excludes}")
    private String excludes;

    @Value("${xss.urlPatterns}")
    private String urlPatterns;

    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 设置过滤器
        registration.setFilter(new XssFilter());
        // 设置过滤器拦截的目标
        registration.addUrlPatterns(StringUtils.split(urlPatterns, ","));
        // 设置过滤器的名称
        registration.setName("xssFilter");
        // 设置过滤器的执行顺序
        registration.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
        // 设置过滤器的初始参数
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("excludes", excludes);
        initParameters.put("enabled", enabled);
        registration.setInitParameters(initParameters);
        return registration;
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 设置过滤器
        registration.setFilter(new RepeatableFilter());
        // 设置过滤器拦截的目标
        registration.addUrlPatterns("/*");
        // 设置过滤器的名称
        registration.setName("repeatableFilter");
        // 设置过滤器的执行顺序
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }
}
