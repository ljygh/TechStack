<%--
  Created by IntelliJ IDEA.
  User: ljy
  Date: 8/19/2021
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <style>
        div{
            background-color: white;
            height: 50px;
        }
        span{
            font-family: Algerian;
            font-size: 30px;
            color: blue;
            margin-left: 2cm;
        }
        a{
            font-family: 华;
            font-size: 20px;
            color: blue;
            margin-left: 6cm;
        }
    </style>
</head>
<body>
<div>
    <span>Tech Stack</span>
    <a href="<%=request.getContextPath()%>/jsp/personal.jsp">我的技术栈</a>
    <a href="<%=request.getContextPath()%>/jsp/explore.jsp">探索</a>
</div>
</body>
</html>
