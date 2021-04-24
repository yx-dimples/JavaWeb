package org.s166.ums.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",initParams = {@WebInitParam(name="encoding",value="UTF-8")})
public class EncodingFilter implements Filter {
    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {
        String encoding = filterConfig.getInitParameter("encoding") ;
        this.encoding = encoding ;
        System.out.println("统一编码的初始化: "+encoding);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.向下转型
        HttpServletRequest request = (HttpServletRequest)servletRequest ;
        HttpServletResponse response = (HttpServletResponse)servletResponse ;
        //2.设置统一编码
        request.setCharacterEncoding(this.encoding);
        //3.放行
        filterChain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("统一编码过滤器－销毁");
    }
}
