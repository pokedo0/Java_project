<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pokedo
  Date: 2017/5/20
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:fielderror></s:fielderror>
<form action="login.action" method="post">
    用户名:<input type="text" name="userName"><br>
    密码:<input type="password" name="password"/><br>
    重复密码:<input type="password" name="repassword"/><br>
    <input type="submit" value="提交"/>
    <s:select list="#{'1':'num1','2':'num2'}" key="select" name="choose"></s:select>
</form>
<s:debug></s:debug>
</body>
</html>
