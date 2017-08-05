<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新留言</title>
    <link rel="stylesheet" type="text/css" href="style/main.css">
</head>
<body>
<%@ include afile="header.jsp" %>
<div class="mainDiv">
    <div class="ui-widget-header" style="text-align: center;">新留言</div>
    <form name="form1" action="/servlet/doPost" type="post">
        <div class="col1">标题</div>
        <div class="col2"><input name="title" size="50"></div>
        <div class="col1">内容</div>
        <div class="col2">
            <textarea rows="20" cols="60" name="content"></textarea>
            <br>
        </div>
        <div class="col2">
            <input type="submit" value="确定">
            <input type="reset">
        </div>
    </form>
</div>
</body>
</html>
