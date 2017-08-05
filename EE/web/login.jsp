<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (session.getAttribute("user") != null)
        response.sendRedirect("index.jsp");
%>

<html>
<head>
    <title>欢迎登陆jsp留言板</title>
    <link rel="stylesheet" type="text/css" href="./style/main.css">
    <style>
        .item {
            padding-left: 380px;
            position: relative;
            padding-bottom: 10px;
        }

        .label {
            width: 360px;
            position: absolute;
            left: 0;
            text-align: right;
        }
    </style>
</head>
<body>
<a href="index.jsp">
    <div class="header"></div>
</a>
<div class="ui-widget-header" style="text-align:center">登录</div>
<div class="ui-widget-content">
    <form id="form1" action="/servlet/doLogin" method="post">
        <div>
            <span class="label">用户名</span>
            <div class="item">
                <input name="userName" id="userName">
            </div>
        </div>
        <div>
            <span class="label">密码</span>
            <div class="item"><input name="password" type="password" id="password"/></div>
        </div>
        <div class="item">
            <input type="submit" value="确认"/>
            <input type="reset" value="重写"/>
            <input type="button" value="注册" id="register" onclick="location='/register.jsp'"/>
        </div>
    </form>
</div>
</body>
</html>
