<%@ page contentType="text/html;charset=UTF-8" import="Bean.User" language="java" %>
<%
    User user = null;
    if (session.getAttribute("user") != null)
        user = (User) session.getAttribute("user");
    else
        response.sendRedirect("login.jsp");
%>
<div>
    <a href="index.jsp">
        <div class="header" style=" display: inline-block;width: 400;"></div>
    </a>
    <div class="welcomePanel">
        <%if (user != null) {%>
        欢迎<span class="userName"><%=user.getUserName()%></span>回来
        <img alt="" src="images/split.jpg">
        <a href="logout.jsp">登出</a>
        <% } %>
    </div>
</div>