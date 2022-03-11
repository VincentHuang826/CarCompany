package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBox
 */
@WebServlet("/CheckBox")

public class CheckBox extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "讀取複選框數據";
        String docType = "<!DOCTYPE html> \n";
            out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<ul>\n" + "  <li><b>色色教程 標示：</b>： " + request.getParameter("sirsir") + "\n" +
                    "  <li><b>壞壞王 標示：</b>： " + request.getParameter("badbadking") + "\n" +
                    "  <li><b>PornHub 標示：</b>： " + request.getParameter("pornhub") + "\n" +
                    "</ul>\n" + "</body></html>");
    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
