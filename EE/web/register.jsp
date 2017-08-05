<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="./style/main.css">
    <style>
        .out {
            height: 100%;
            width: 100%;
        }

        .label {
            width: 40%;
            display: inline-block;
            text-align: right;
            margin-bottom: 10px;
            margin-right: 20px;
        }
    </style>
    <script type="text/javascript">
        //验证表单！
        function fun() {
            var password = myform.password.value;
            var username = myform.username.value;
            var repeat = myform.repeat.value;
            console.log(password);
            console.log(repeat);
            console.log(username);
            if (username == "" || username == null) {
                alert("用户名不能为空！");
                return false;
            }
            if (password != repeat || password == null || password == "") {
                alert("密码不一致或为空");
                return false;
            }
            return true;
        }
    </script>

</head>
<body>
<a href="index.jsp">
    <div class="header"></div>
</a>

<form name="myform" class="out" action="/servlet/doRegist" onsubmit="return fun()" method="post">
    <div>
        <span class="label">用户名</span>
        <span><input name="username" id="username"></span>
    </div>
    <div>
        <span class="label">密码</span>
        <span><input type="password" name="password" id="password"></span>
    </div>
    <div>
        <span class="label">重复密码</span>
        <span><input type="password" name="repeat" id="repeat"></span>
    </div>
    <div>
        <span class="label">性别</span>
        <span>
            <input type="radio" checked="checked" name="sex" value="1"> 男
            <input type="radio" name="sex" value="2"> 女
        </span>
    </div>
    <div>
        <span class="label">请选择头像</span>
        <div style="display: block; margin-left: 45%;">
            <%for (int i = 1; i <= 3; i++) {%>
            <span>
                            <input type="radio" name="pic" value="<%out.print(i*5-4);%>">
                            <img src="images/head/<%out.print(i*5-4);%>.gif">
                    </span>
            <span>
                            <input type="radio" name="pic" value="<%out.print(i*5-3);%>">
                            <img src="images/head/<%out.print(i*5-3);%>.gif">
                    </span>
            <span>
                            <input type="radio" name="pic" value="<%out.print(i*5-2);%>">
                            <img src="images/head/<%out.print(i*5-2);%>.gif">
                    </span>
            <span>
                            <input type="radio" name="pic" value="<%out.print(i*5-1);%>">
                            <img src="images/head/<%out.print(i*5-1);%>.gif">
                    </span>
            <span>
                            <input type="radio" name="pic" value="<%out.print(i*5);%>">
                            <img src="images/head/<%out.print(i*5);%>.gif">
                    </span>
            <br/>
            <%}%>
            <input type="submit" value="注册" name="regist" style="margin: 10px;"/>
        </div>
    </div>

</form>

</body>
</html>
