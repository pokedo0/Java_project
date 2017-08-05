<%@ page import="Bean.Notes" %>
<%@ page import="Dao.NotesDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int noteId = Integer.parseInt(request.getParameter("noteId").toString());
    Notes note = new NotesDaoImpl().getNoteById(noteId);
%>

<html>
<head>
    <title>留言内容</title>
    <link rel="stylesheet" type="text/css" href="style/main.css"/>
</head>
<body>
<%@include afile="header.jsp" %>
<a href="post.jsp"><img src="images/book_write.png"/> </a>
<div class="ui-widget-header" style="text-align: center;"></div>
<div class="col1">留言人</div>
<div class="col2">内容</div>
<div class="clear"></div>
<div class="col1 rightalign">
    <img src="./images/head/<%=note.getUser().getHead()%>"/><br/>
    用户名:<%=note.getUser().getUserName()%><br/>
    注册时间:<%=note.getUser().getRegTime()%>
</div>
<div class="col2"><%=note.getContent()%>
</div>
</body>
</html>