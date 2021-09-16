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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
<div class="titleBlock">
    <span class="title">Tech Stack</span><br>
    <span class="text">技术栈 技术精湛</span>
</div>
<div class="loginBlock">
    <form method="post" onsubmit="return submitCheck()" action= "<%=request.getContextPath()%>/LoginValidateServlet">
        <input id="username" name="username" placeholder="用户名" size="20" maxlength="20" onchange="nameChange()"><br>
        <p id="nameNotice"></p>
        <input id="password" name="password" placeholder="密码" size="20" maxlength="20" onchange="pswdChange()" type="password"><br>
        <p id="pswdNotice"></p>
        <input class="button" type="submit" size="20" value="登录">
    </form>
    <a href="<%=request.getContextPath()%>/jsp/signup.jsp">还没注册？ 去注册</a>
</div>
</body>
<%-- js放在head中是调用的时候运行，body中是加载页面时运行。--%>
<%-- js中改动页面中元素要在元素之后，最好放在body之后 --%>
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
</script>
<%
    }
    String message = request.getParameter("message");
    if(message != null && !message.equals("")){
%>
<script>
    alert("<%=message%>");
</script>
<%
    }
%>
</html>
