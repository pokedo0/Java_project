<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:include value="header.jsp"></s:include>
<html>
<head>
    <title>查看留言</title>
</head>
<body>
<a href="addnote.action"><img src="images/book_write.png"></a>
<div class="titlehead">
    &nbsp;
</div>

<div class="col1">留言人</div>
<div class="col2">主题</div>
<div style="clear: both"></div>
<div class="col1">
    <img src="images/head/${note.user.head}"/><br>
    用户名:<s:property value="note.user.userName"/><br>
    注册时间:<s:property value="note.user.regTime"/><br>
</div>
<div class="col2">
    <s:property escape="false" value="note.content"></s:property><br>
    <s:push value="note.attachment">
        <s:if test="note.attachment != ''">
            <s:url action="download" id="myUrl">
                <s:param name="fileName">
                    <s:property value="note.attachment"></s:property>
                </s:param>
            </s:url>
            <s:a href="%{myUrl}">附件</s:a>
        </s:if>
    </s:push>
</div>

<div style="clear: both"></div>
<s:debug></s:debug>

</body>
</html>