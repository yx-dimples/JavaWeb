package org.s166.ums.util;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域处理
 */
@WebFilter(urlPatterns = "/*")
public class CORSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("跨域处理... ");
    }


    public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain)
            throws IOException, ServletException {
        //1.向下转型
        HttpServletRequest request = (HttpServletRequest)sRequest ;
        HttpServletResponse response = (HttpServletResponse)sResponse ;
        //2.设置相关的头信息
        // 允许所有的域名
        // response.setHeader("Access-Control-Allow-Origin", "*");
        String origin = request.getHeader("Origin") ;
        response.setHeader("Access-Control-Allow-Origin", origin);
        // 允许发送cookies
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 允许请求所有的方法
        response.setHeader("Access-Control-Allow-Methods", "DELETE,PUT,POST,GET");
        // 预检请求的最大超时（有效）时间为3600秒
        response.setHeader("Access-Control-Max-Age", "3600");
        // 定义可以返回的头部信息字段
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin,X-Requested-With,Content-Type,Accept,"
                + "content-Type,origin,x-requested-with,content-type,accept,authorization,token,id,X-Custom-Header,X-Cookie,Connection,User-Agent,Cookie,*");
        response.setHeader("Access-Control-Request-Headers", "Authorization,Origin, X-Requested-With,content-Type,Accept");
        // 可以暴露给外部所有头部信息字段
        response.setHeader("Access-Control-Expose-Headers", "*");
        //3.放行
        chain.doFilter(request, response);
    }


    public void destroy() {
        System.out.println("跨域处理－销毁");
    }
}
