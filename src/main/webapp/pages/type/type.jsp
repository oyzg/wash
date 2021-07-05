<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/30
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>价目表</title>
    <%-- 静态包含base标签、css样式、jQuery文件 --%>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif" >
    <span class="wel_word">价目表</span>
    <%-- 静态包含，登录成功之后的菜单 --%>
    <%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

    <table>
        <tr>
            <td>衣物类型id</td>
            <td>衣物类型名</td>
            <td>衣物类型单价</td>
        </tr>
        <c:forEach items="${requestScope.tlist}" var="type">
            <tr>
                <td>${type.tid}</td>
                <td>${type.tname}</td>
                <td>${type.unitprice}</td>
            </tr>
        </c:forEach>
    </table>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
