<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:include value="header.jsp"></s:include>
<html>
<head>
    <title>新留言</title>
    <link rel="stylesheet" type="text/css" href="./style/main.css">
    <style>
        .col2margin {
            margin-left: 5%;
        }
    </style>
</head>
<body>
<%!%>
<div class="titlehead">
    新留言
</div>
<form name="postform" action="addnote.action" method="post" enctype="multipart/form-data">
    <div class="col1">
        标题
    </div>
    <div class="col2 col2margin">
        <input type="text" name="note.title" id="title">
    </div>
    <div style="clear: both"></div>
    <div class="col1">
        内容
    </div>
    <div class="col2 col2margin">
        <textarea name="note.content" id="content" rows="20" cols="60"></textarea>
    </div>
    <div style="clear:both;"></div>
    <div class="col1"></div>
    <div class="col2">
        <input type="file" name="upfile">
    </div>
    <br>
    <div class="col2" style="margin-left: 40%">
        <input type="submit" value="确定"/>
        <input type="reset" value="重置">
    </div>
</form>

</body>
</html>
