package com.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Locale;
import java.text.NumberFormat;


@WebServlet("/PercentageLocale")

public class PercentageLocale extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取客户端的区域设置
        Locale locale = request.getLocale();
        NumberFormat nft = NumberFormat.getPercentInstance(locale);
        String formattedPerc = nft.format(0.51);

        String title = "特定於區域設置的百分比";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType + "<html>\n" +
                "<head><title>" + title + "</title></haed>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 aling=\"center\">" + formattedPerc + "</h1>\n" +
                "</body></html>");
    }
}
