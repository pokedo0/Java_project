<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="title"></s:text></title>
    <link rel="stylesheet" type="text/css" href="style/main.css">
    <script type="text/javascript">
        function lang_onChanged() {
            document.getElementById("langForm").submit();
        }
    </script>
</head>
<s:include value="header.jsp"></s:include>
<div class="titlehead">
    <s:text name="title"></s:text>
</div>
<body>
<s:set name="session_locale" value="#session['WW_TRANS_I18N_LOCALE']"/>
<form action="<s:url/>" id="langForm" style="background-color: #e78f08">
    <s:select name="request_locale" list="#{@java.util.Locale@CHINA:getText('chinese'),
    @java.util.Locale@US:getText('english')}"
              value="#session_locale==null?locale:#session_locale" onchange="lang_onChanged()"
              key="selectlanguage"></s:select>
</form>

<form name="regform" method="post" action="register.action">
    <div>
        <div class="left_label"><s:text name="userName"></s:text></div>
        <div class="item"><input name="userName" type="text"/></div>
    </div>
    <div>
        <div class="left_label"><s:text name="password"></s:text></div>
        <div class="item"><input name="password" type="password"/></div>
    </div>
    <div>
        <div class="left_label"><s:text name="repeat"></s:text></div>
        <div class="item"><input name="repeat" type="password"/></div>
    </div>
    <div>
        <div class="item"><s:fielderror></s:fielderror></div>
    </div>
    <div>
        <div class="left_label"><s:text name="gender"></s:text></div>
        <div class="item"><input type="radio" name="gender" checked="checked" value="1"/><s:text
                name="gender.male"></s:text>
            <input type="radio" name="gender" value="2"/><s:text name="gender.female"></s:text>
        </div>
    </div>
    <div>
        <div class="left_label"><s:text name="photo"></s:text></div>
        <div class="item">
            <s:iterator value="headList" var="list">
                <input type="radio" name="head" value="${list}"/>
                <img src="images/head/${list}.gif"/>
                <s:if test="#list %5 ==0">
                    <br/>
                </s:if>
            </s:iterator>
        </div>
    </div>
    <div style="margin-right: 50%">
        <s:submit key="submit"></s:submit>
    </div>
    <s:debug></s:debug>
</form>
</body>
</html>