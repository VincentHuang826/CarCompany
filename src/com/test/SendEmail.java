package com.test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 收件人的电子邮件 ID
        String to = "rockguitar826@hotmail.com";

        // 发件人的电子邮件 ID
        String from = "rockguitar826@gmail.com";

        // 假设您是从本地主机发送电子邮件
        String host = "localhost";

        // 获取系统的属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        // 获取默认的 Session 对象
        Session session = Session.getDefaultInstance(properties);

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 创建一个默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // 设置 From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // 设置 To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 设置 Subject: header field
            message.setSubject("This is the Subject Line!");
            // 现在设置实际消息
            message.setText("This is actual message");
            // 发送消息
            Transport.send(message);
            String title = "發送電子郵件";
            String res = "成功發送訊息";
            String docType = "<!DOCTYPE html>\n";
            out.println(docType + "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<p align=\"center\">" + res + "</p>\n" +
                    "</body></html>");
        } catch(MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
