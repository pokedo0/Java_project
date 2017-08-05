<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.removeAttribute("user");
    response.sendRedirect("login.jsp");
%>