package com.shopping.micro.orders.configuration.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置拦截地址
        registry.addInterceptor(myInterceptor()).addPathPatterns("/service/**")
            .excludePathPatterns(           // 个人注册相关接口
                    "/service/v1/user.register" // 个人注册
            );

    }
}
