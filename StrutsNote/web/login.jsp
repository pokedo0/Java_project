<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:include value="header.jsp"></s:include>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="./style/main.css">
</head>
<body>
<div class="titlehead">
    登录
</div>
<form action="loginact.action" name="loginform" method="post">
    <div>
        <div class="left_label">用户名:</div>
        <div class="item"><input name="userName" id="userName" type="text"></div>
    </div>
    <div>
        <div class="left_label">密码:</div>
        <div class="item"><input name="password" id="password" type="text"></div>
    </div>
    <div class="item">
        <input type="submit" value="确认"/>
        <input type="reset" value="重写"/>
        <input type="button" value="注册" onclick="location='register.action'"/>
    </div>
    <s:actionerror></s:actionerror>
</form>

</body>
</html>
