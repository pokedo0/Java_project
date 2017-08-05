<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pokedo
  Date: 2017/5/26
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:text name="welcome"></s:text>
<br>
<s:text name="hello">
    <s:param>黎明</s:param>
    <s:param>2012</s:param>
</s:text>
<br>

<s:i18n name="message">
    <s:text name="hello"></s:text>
</s:i18n>
<s:debug></s:debug>
</body>
</html>
