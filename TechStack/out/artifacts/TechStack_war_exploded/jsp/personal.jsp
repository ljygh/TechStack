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
    <link rel="stylesheet" type="text/css" href="../css/personal.css">
    <script src="../js/personal.js"></script>
    <%
        String message = request.getParameter("message");
        if(message != null){
    %>
            <script>
                alert("<%=message%>");
            </script>
    <%
        }
    %>
</head>
<body>
<div><jsp:include page="menu.jsp"></jsp:include></div>
<div class="userCenter">
    <img src="<%=request.getContextPath()%>/img/user.jpg"><br>
    <p><%=session.getAttribute("username")%></p>
    <form method="post" action="<%=request.getContextPath()%>/LogOutServlet" onsubmit="return logOutConfirm()">
        <input type="submit" value="退出登录">
    </form>
    <form method="post" onsubmit="return closeAccountConfirm()" action="<%=request.getContextPath()%>/CloseAccountServlet">
        <input type="submit" value="注销账号">
    </form>
    <input type="button" value="修改密码" onclick="edit()"><br>
    <form class="changePswd" id="form" action="<%=request.getContextPath()%>/ChangePasswordServlet" onsubmit="return submitCheck()">
        <input id="pswd" name="pswd" placeholder="密码" maxlength="20" onchange="pswdChange()" type="password"><br>
        <p id="pswdNotice" class="notice"></p>
        <input id="confirmPswd" placeholder="确认密码" maxlength="20" onchange="confirmPswdChange()" type="password"><br>
        <p id="confirmPswdNotice" class="notice"></p>
        <input type="submit" value="保存"> <input type="button" value="取消" onclick="cancel()">
    </form>
</div>
</body>
</html>
