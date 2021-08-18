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
    <%
        String error = request.getParameter("error");
        if(error != null && !error.equals("")){
            System.out.println("error:" + error);
    %>
            <script>
                alert("错误：<%=error%>");
                document.writeln("<%=error%>");
                console.log("errot：<%=error%>")
            </script>
    <%
        }
    %>
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
        <input id="password" name="password" placeholder="密码" size="20" maxlength="20" onchange="pswdChange()"><br>
        <p id="pswdNotice"></p>
        <input class="button" type="submit" size="20" value="提交">
    </form>
    <a>还没注册？ 去注册</a>
</div>
</body>
</html>
