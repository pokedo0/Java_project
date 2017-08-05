<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="./style/main.css">
</head>
<body>
<div style="width: 100%;">
    <div class="headerleft">
        <a href="listnotes.action"><img src="images/logo.png"></a>
    </div>
    <div class="headerright">
        <s:if test="null != #session.user">
            欢迎 <s:property value="#session.user.userName"></s:property>
            回来|<a href="logout.action">登出</a>
        </s:if>
        <s:else>
            <a href="login.jsp">登录</a>
        </s:else>
    </div>
</div>
</body>
</html>
