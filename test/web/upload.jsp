<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pokedo
  Date: 2017/5/14
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="upload.action" enctype="multipart/form-data" method="post">
    附件:<input type="file" name="afile"/>
    <input type="submit" value="提交">
</form>

<h1>listupload</h1>
<form action="upload2.action" enctype="multipart/form-data" method="post">
    附件：<input type="file" name="file"/>
    附件：<input type="file" name="file"/>
    附件：<input type="file" name="file"/>
    <input type="submit" value="提交"/>
</form>
<s:debug></s:debug>
</body>
</html>
