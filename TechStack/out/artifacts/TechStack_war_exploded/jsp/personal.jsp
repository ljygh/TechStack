<%--
  Created by IntelliJ IDEA.
  User: ljy
  Date: 8/17/2021
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal main</title>
    <style>
        body{
            background-color: aliceblue;
        }
        div.userCenter{
            margin-left: 2cm;
            margin-top: 10px;
            background-color: white;
            width: 10cm;
            height: 15cm;
        }
        img{
            width: 4cm;
            height: 5cm;
            margin-left: 2cm;
        }
        input{
            margin-left: 2cm;
            margin-top: 0.5cm;
        }
        p{
            margin-top: 0.5cm;
            margin-left: 2cm;
        }
        form{
            display: none;
        }
    </style>
    <script>
        function edit(){
            document.getElementById("form").style.display = "block";
        }
        function cancel(){
            document.getElementById("form").style.display = "none";
        }
    </script>
</head>
<body>
<div><jsp:include page="menu.jsp"></jsp:include></div>
<div class="userCenter">
    <img src="<%=request.getContextPath()%>/img/user.jpg"><br>
    <p><%=session.getAttribute("username")%></p>
    <input type="button" value="编辑资料" onclick="edit()"><br>
    <form id="form">
        <input placeholder="用户名"><br>
        <input placeholder="密码"><br>
        <input placeholder="确认密码"><br>
        <input type="submit" value="保存"> <input type="button" value="取消" onclick="cancel()">
    </form>
</div>
</body>
</html>
