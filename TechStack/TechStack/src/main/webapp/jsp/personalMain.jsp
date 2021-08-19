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
</head>
<body>
Hello <%=session.getAttribute("userid")%> <%=session.getAttribute("username")%>
</body>
</html>
