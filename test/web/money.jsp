<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pokedo
  Date: 2017/6/2
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="money.action" method="post">
    美元:<input type="text" name="money"><br>
    <input type="submit">
</form>
<s:property value="result"></s:property>
<s:debug></s:debug>
</body>
</html>
