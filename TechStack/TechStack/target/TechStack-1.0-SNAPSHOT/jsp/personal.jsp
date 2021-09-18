<%@ page import="java.util.List" %>
<%@ page import="bean.Stack" %>
<%@ page import="java.util.LinkedList" %><%--
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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/personal.css">
    <script src="<%=request.getContextPath()%>/js/personal.js"></script>
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
    <%
        List<Stack> stackList = (List<Stack>) request.getAttribute("stackList");
        if(stackList == null)
            stackList = new LinkedList<>();
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
<div class="stacks">
    <form onsubmit="return searchStackCheck()" action="<%=request.getContextPath()%>/SearchStackServlet">
        <input id="searchName" name="stackname" placeholder="请输入要搜索的技术栈名称" size="25" maxlength="50">
        <input type="submit" value="搜索"><br>
        <p class="notice" id="searchNameNotice"></p>
    </form>
    <input type="button" value="新建技术栈" onclick="showCreateStackForm()"><br>
    <form id="createStackForm" style="display: none" onsubmit="return addStackCheck()" action="<%=request.getContextPath()%>/AddStackServlet">
        <input id="stackName" name="sname" placeholder="技术栈名" onchange="nameChange()" maxlength="50"><br>
        <p id="sNameNotice" class="notice"></p>
        <textarea id="stackDescription" name="sDescription" placeholder="技术栈简介" cols="50" rows="2" onchange="descriptionChange()" maxlength="100"></textarea><br>
        <p id="sDescriptionNotice" class="notice"></p>
        <input type="submit" value="新建">
        <input type="button" value="取消" onclick="cancelCreateStack()">
    </form>
    <%
        for(Stack stack : stackList){
            String sname = stack.getSname();
            String description = stack.getDescription();
    %>
            <div class="stack">
                <%-- 标签a 设置为display: block , 方便调整位置。--%>
                <a class="sName" href="<%=request.getContextPath()%>/jsp/stack.jsp"><%=sname%></a><br>
                <p class="description"><%=description%></p>
            </div>
    <%
        }
    %>
</div>
</body>
</html>
