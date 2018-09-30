package com.marvel.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Marvel on 18/09/30.
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    // 格式化
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    // 跨域访问配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    // URI 到视图的映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
