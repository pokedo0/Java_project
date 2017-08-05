<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pokedo
  Date: 2017/6/2
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="deptAdd.action" method="post">
    <table>
        <tr>
            <th>部门编码</th>
            <th>部门名称</th>
            <th>办公地点</th>
            <th>备注</th>
        </tr>
        <s:iterator value="new int[2]" status="st">
            <tr>
                <td>
                    <s:textfield name="%{'depts['+#st.index+'].deptid'}"/>
                </td>
                <td>
                    <s:textfield name="%{'depts['+#st.index+'].dName'}"/>
                </td>
                <td>
                    <s:textfield name="%{'depts['+#st.index+'].loc'}"/>
                </td>
                <td>
                    <s:textfield name="%{'memo['+#st.index+']'}"/>
                </td>
            </tr>
        </s:iterator>
        <tr>
            <s:submit></s:submit>
        </tr>
    </table>
</form>
<s:debug></s:debug>

</body>
</html>
