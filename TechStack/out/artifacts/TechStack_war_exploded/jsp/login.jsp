<%--
  Created by IntelliJ IDEA.
  User: ljy
  Date: 8/17/2021
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>log in page</title>
    <style>
        body{
            background-image: url("<%=request.getContextPath()%>/img/login.jpg");
        }
        span.title{
            margin-left: 2cm;
            font-size: 30px;
            font-weight: bold;
            font-family: "Times New Roman";
            color: indigo;
        }
        span.text{
            margin-left: 3cm;
            font-size: 10px;
            color: indigo;
        }
        div.titleBlock{
            margin-top: 10%;
            margin-left: 38%;
            margin-bottom: 1cm;
        }
        div.loginBlock{
            margin-left: 38%;
            width: 300px;
            height: 400px;
            background-color: aliceblue;
        }
        input{
            margin-top: 0.5cm;
            margin-left: 2cm;
        }
        input.button{
            margin-top: 1cm;
            margin-left: 2cm;
            background-color: blue;
            color: white;
        }
        a{
            margin-left: 2cm;
            color: blue;
        }
        p{
            color: red;
            margin-left: 2cm;
        }
    </style>
    <script>
        function submitCheck(){
            var res = true;
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            if(username == ""){
                document.getElementById("nameNotice").innerHTML = "用户名不能为空";
                res = false;
            }
            if(password == ""){
                document.getElementById("pswdNotice").innerHTML = "密码不能为空";
                res = false;
            }
            return res;
        }
        function nameChange(){
            var name = document.getElementById("username").value;
            if(name != "")
                document.getElementById("nameNotice").innerText = "";
        }
        function pswdChange(){
            var password = document.getElementById("password").value;
            if(password != "")
                document.getElementById("pswdNotice").innerText = "";
        }
    </script>
</head>
<body>
<div class="titleBlock">
    <span class="title">Tech Stack</span><br>
    <span class="text">技术栈 技术精湛</span>
</div>
<div class="loginBlock">
    <form method="post" onsubmit="return submitCheck()">
        <input id="username" name="username" placeholder="用户名" size="20" maxlength="20" onchange="nameChange()"><br>
        <p id="nameNotice"></p>
        <input id="password" name="password" placeholder="密码" size="20" maxlength="20" onchange="pswdChange()"><br>
        <p id="pswdNotice"></p>
        <input class="button" type="submit" size="20" value="提交">
    </form>
    <a>还没注册？ 去注册</a>
</div>
</body>
</html>
