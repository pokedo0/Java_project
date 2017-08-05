<%@ page import="com.sun.corba.se.spi.orbutil.fsm.Input" %>
<%@ page import="org.apache.struts2.components.Include" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:include value="header.jsp"></s:include>

<html>
<head>
    <title>留言列表</title>
</head>
<body>
<a href="addnote.action"><img src="images/book_write.png"></a>
<div class="titlehead">
    留言列表
</div>

<div class="col1">留言人</div>
<div class="col2">主题</div>

<s:iterator value="notesList" var="note">
    <div style="clear: both;"></div>
    <div class="col1">
        <s:property value="#note.user.userName"></s:property>
    </div>
    <div class="col2">
        <s:a href="detail.action?noteId=%{#note.noteId}">
            <s:property value="#note.title"></s:property>
        </s:a>
    </div>
</s:iterator>

<s:debug></s:debug>

</body>
</html>