<%@ page import="Dao.NotesDao" %>
<%@ page import="Dao.NotesDaoImpl" %>
<%@ page import="Bean.Notes" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    NotesDao notesDao = new NotesDaoImpl();
    List<Notes> list = notesDao.getAllNotes();
%>
<html>
<head>
    <title>留言列表</title>
    <link rel="stylesheet" type="text/css" href="./style/main.css">
</head>
<body>
<a href="index.jsp">
    <div class="header"></div>
</a>
<a href="post.jsp"><img src="./images/book_write.png"/> </a>
<div class="ui-widget-header" style="text-align: center;">留言列表</div>
<div class="col1">留言人</div>
<div class="col2">主题</div>
<%
    Iterator<Notes> it = list.iterator();
    while (it.hasNext()) {
        Notes note = it.next();
%>
<div class="clear"></div>
<div class="col1">
    <%=note.getUser().getUserName()%><!-- 显示留言人 -->
</div>

<div class="col2">
    <a href="detail.jsp?noteId=<%=note.getNoteId()%>">
        <%=note.getTitle()%>
    </a>
</div>
<%}%>

</body>
</html>
