package com.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

//扩展 HttpServlet 类
public class ErrorHandler extends HttpServlet {

    // 处理 GET 方法请求的方法
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        String servletName =(String)request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "色色教程 Error/Exception 信息";

        String docType = "<!DOCTYPE html>\n";
        out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
        out.println("<h1>色色教程異常信息實例演示</h1>");

        if (throwable == null && statusCode == null) {
            out.println("<h2>錯誤信息丟失</h2>");
            out.println("請返回 <a href=\"" + response.encodeURL("http://localhost:8080/") + "\">主頁</a>。");
        } else if (statusCode != null) {
            out.println("錯誤代碼： " + statusCode);
        } else {
            out.println("<h2>錯誤信息</h2>");
            out.println("Servlet Name: " + servletName + "</br></br>");
            out.println("異常類型： " + throwable.getClass().getName() + "</br></br>");
            out.println("請求 URI： " + requestUri + "</br></br>");
            out.println("異常信息： " + throwable.getMessage());
        }
        out.println("</body>");
        out.println("</html>");
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
