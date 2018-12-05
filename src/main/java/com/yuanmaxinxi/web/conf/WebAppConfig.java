package com.yuanmaxinxi.web.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yuanmaxinxi.service.resource.ResourceService;
import com.yuanmaxinxi.web.interceptor.LoginInterceptor;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {  
	@Autowired
	private ResourceService resourceService;
    @Override  
    public void addInterceptors(InterceptorRegistry registry) {  
        //注册自定义拦截器，添加拦截路径和排除拦截路径  
        registry.addInterceptor(new LoginInterceptor(resourceService)).addPathPatterns("/**").excludePathPatterns("/index/**","/login/**","/commons/**","/H-ui/**","/ueditor/**");  
    }  
}