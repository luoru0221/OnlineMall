package com.rul.mall.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 使用拦截器将所有请求响应设置成统一的编码格式，防止乱码
 */
@WebFilter("/*")
public class CharSetFilter implements Filter {

    private String myEncoding;
    public CharSetFilter(){

    }

    @Override
    public void init(FilterConfig filterConfig){
        this.myEncoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(myEncoding);
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.setCharacterEncoding(myEncoding);
    }

    @Override
    public void destroy() {

    }
}
