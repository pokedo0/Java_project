<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pokedo
  Date: 2017/6/2
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>部门编码</th>
        <th>部门名称</th>
        <th>办公地点</th>
        <th>备注</th>
    </tr>
    <s:iterator value="depts" status="st">
        <tr>
            <td>
                <s:property value="key"></s:property>
            </td>
            <td>
                <s:property value="value.deptid"></s:property>
            </td>
            <td>
                <s:property value="value.dName"></s:property>
            </td>
            <td>
                <s:property value="value.loc"></s:property>
            </td>
            <td>
                <s:property value="memo[key]"></s:property>
            </td>
        </tr>

    </s:iterator>
    <tr>
        <s:submit></s:submit>
    </tr>
</table>
<s:debug></s:debug>

</body>
</html>
