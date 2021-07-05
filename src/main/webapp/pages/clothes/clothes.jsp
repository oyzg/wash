<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/30
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
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
    <span class="wel_word">我的订单</span>
    <%-- 静态包含，登录成功之后的菜单 --%>
    <%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

    <table>
        <tr>
            <td>衣物id</td>
            <td>衣物数量</td>
            <td>物主</td>
            <td>负责店员</td>
            <td>日期</td>
            <td>衣物类型</td>
        </tr>
        <c:forEach items="${requestScope.bymlist}" var="clothes">
            <tr>
                <td>${clothes.cid}</td>
                <td>${clothes.ccount}</td>
                <td>${clothes.mid}</td>
                <td>${clothes.aid}</td>
                <td>${clothes.date}</td>
                <td>${clothes.tid}</td>
                <td><a href="#">重洗</a> </td>
                <td><a href="#">退赔</a> </td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>>
            <td></td>>
            <td></td>>
            <td></td>>
            <td><a href="clothesServlet?action=settle">结算</a></td>>
        </tr>
    </table>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
