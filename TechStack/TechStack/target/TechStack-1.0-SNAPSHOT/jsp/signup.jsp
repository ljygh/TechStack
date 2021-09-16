<%--
  Created by IntelliJ IDEA.
  User: ljy
  Date: 8/18/2021
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signup.css">
    <script src="${pageContext.request.contextPath}/js/signup.js"></script>
</head>
<body>
<div class="image"><img src="<%=request.getContextPath()%>/img/signup.jpg"></div>
<div class="signBlock">
    <p>Tech Stack</p>
    <form method="post" onsubmit="return submitCheck()" action="<%=request.getContextPath()%>/SignupServlet">
        <input id="username" name="username" placeholder="用户名" maxlength="20" onchange="nameChange()"><br>
        <span id="nameNotice"></span><br>
        <input id="password" name="password" placeholder="密码" maxlength="20" type="password" onchange="pswdChange()"><br>
        <span id="pswdNotice"></span><br>
        <input id="passwordConfirm" name="passwordConfirm" placeholder="确认密码" maxlength="20" type="password" onchange="pswdCnfmChange()"><br>
        <span id="pswdCnfmNotice"></span><br>
        <input type="submit" value="注册">
    </form>
    <a href="<%=request.getContextPath()%>/jsp/login.jsp">返回</a>
</div>
</body>
<%
    String username = request.getParameter("username");
    if(username != null){
%>
<script>
    document.getElementById("username").value = "<%=username%>";
</script>
<%
    }
    String password = request.getParameter("password");
    if(password != null){
%>
<script>
    document.getElementById("password").value = "<%=password%>";
    document.getElementById("passwordConfirm").value = "<%=password%>";
</script>
<%
    }
    String error = request.getParameter("error");
    if(error != null && !error.equals("")){
%>
<script>
    alert("错误：<%=error%>");
</script>
<%
    }
%>
</html>
