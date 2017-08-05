<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pokedo
  Date: 2017/5/28
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="test.action">
    <input type="submit" value="submit">
</form>
<s:set name="temp" value="#{'one':'red','two':'blue','three':'hhh'}"></s:set>

<s:iterator value="temp">
    <s:property value="key"></s:property> : <s:property value="value"/><br/>
    <s:debug></s:debug>
</s:iterator>

</body>
</html>
