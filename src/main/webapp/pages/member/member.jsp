<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/29
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>我的店员</title>
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
  <span class="wel_word">我的会员</span>
  <%-- 静态包含，登录成功之后的菜单 --%>
  <%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

  <table>
    <tr>
      <td>会员id</td>
      <td>会员名字</td>
      <td>会员等级</td>
      <td>会员余额</td>
      <td>会员密码</td>
    </tr>
    <c:forEach items="${requestScope.mlist}" var="member">
      <tr>
        <td>${member.mid}</td>
        <td>${member.mname}</td>
        <td>${member.grade}</td>
        <td>${member.balance}</td>
        <td>${member.password}</td>
        <td>
          <a href="memberServlet?action=getMember&id=${member.mid}&name=${member.mname}&grade=${member.grade}&balance=${member.balance}&password=${member.password}">修改</a>
        </td>
        <td>
          <a href="memberServlet?action=delete&id=${member.mid}">删除</a>
        </td>
      </tr>
    </c:forEach>
    <tr>
      <td></td>
      <td></td>>
      <td></td>>
      <td><a href="pages/member/member_edit.jsp">添加会员</a></td>
    </tr>
  </table>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
