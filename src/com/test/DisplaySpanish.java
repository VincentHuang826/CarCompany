package com.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Locale;

@WebServlet("/DisplaySpanish")

public class DisplaySpanish extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 设置西班牙语言代码
        response.setHeader("Content-Language", "es");

        String title = "En Espa&ntilde;ol";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType + "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1>" + "En Espa&ntilde;ol:" + "</h1>\n" +
                "<h1>" + "&iexcl;Hola Mundo!" + "</h1>\n" +
                "</body></html>");
    }
}
