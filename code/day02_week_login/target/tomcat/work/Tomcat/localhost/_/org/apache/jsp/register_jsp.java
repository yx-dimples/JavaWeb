/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-04-22 02:20:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./style.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("        .logo-box {\r\n");
      out.write("            width:404px;\r\n");
      out.write("            margin: 40px auto;\r\n");
      out.write("            border:1px solid #e5e5e5;\r\n");
      out.write("            border-radius:4px;\r\n");
      out.write("            box-shadow:0 4px 18px rgba(0,0,0,0.2);\r\n");
      out.write("            position:relative;\r\n");
      out.write("            overflow:hidden;\r\n");
      out.write("            height: 420px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2 style=\"text-align: center\">用户注册</h2>\r\n");
      out.write("<div class=\"logo-box\">\r\n");
      out.write("    <div class=\"login\">\r\n");
      out.write("        <div class=\"bxs-row\" style=\"text-align: center\">\r\n");
      out.write("            <img id=\"logo\" src=\"logo.jpg\" alt=\"\" width=\"72px\">\r\n");
      out.write("            <span class=\"tips\" style=\"color: red\">忍住不哭来段口技</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <form method=\"post\" action=\"/RegisterServlet\">\r\n");
      out.write("            <div class=\"bxs-row\">\r\n");
      out.write("                <label for=\"username\">用户名</label>\r\n");
      out.write("                <input type=\"text\" id=\"username\" name=\"username\" class=\"username\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"bxs-row\">\r\n");
      out.write("                <label for=\"password\">密码</label>\r\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\" class=\"password\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"bxs-row\">\r\n");
      out.write("                <button type=\"submit\" class=\"submit btn\">注册</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <div class=\"bxs-row\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn\" onclick=\"window.open('login.jsp')\">登录</button>\r\n");
      out.write("            <p style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inf}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}