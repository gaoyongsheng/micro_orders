package com.shopping.micro.orders.configuration.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Slf4j
@Configuration
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        MyRequestWrapper myRequestWrapper = new MyRequestWrapper(httpServletRequest);
        filterChain.doFilter(myRequestWrapper,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("destory");
    }

}
