package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class charsetFilter implements Filter {

    private String encode = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encode = filterConfig.getInitParameter("encoding");//获取编码格式
        System.out.println(this.encode);//可以打印出来看是否获取
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        if(this.encode != null && !this.encode.equals("")){
            request.setCharacterEncoding(this.encode);
            response.setContentType("text/html;charset=utf-8");
        }else{
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
