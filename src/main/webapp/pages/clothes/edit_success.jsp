<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/30
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>下单成功</title>
    <%-- 静态包含base标签、css样式、jQuery文件 --%>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }
    </style>
</head>
<body>
<div id="header">
    <%--				<img class="logo_img" alt="" src="static/img/logo.gif" >--%>
    <%-- 静态包含，登录成功之后的菜单 --%>
    <%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

    <c:if test="${not empty sessionScope.member}">
        <h1>下单成功 <a href="clothesServlet?action=findByMid&mid=${sessionScope.member.mid}">查看我的订单</a></h1>
    </c:if>

    <c:if test="${not empty sessionScope.assistant}">
        <h1>添加成功 <a href="clothesServlet?action=list">查看订单</a></h1>
    </c:if>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
