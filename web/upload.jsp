<%--
  Created by IntelliJ IDEA.
  User: Vincent.Huang
  Date: 2022/3/31
  Time: 下午 03:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上傳實例 - 色色教程</title>
</head>
<body>
    <h1>文件上傳實例 - 色色教程</h1>
        <form method="post" action="/CarCompany/UploadServlet" enctype="multipart/form-data">
            選擇一個文件:
            <input type="file" name="uploadFile" />
            <br/><br/>
            <input type="submit" value="上傳" />
        </form>
</body>
</html>
