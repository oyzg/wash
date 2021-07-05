<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/30
  Time: 13:50
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
  <span class="wel_word">我的订单</span>
  <%-- 静态包含，登录成功之后的菜单 --%>
  <%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

  <div class="form">
    <form action= "clothesServlet" method="post">
      <input type="hidden" name="action" value="findByDate">
      <label>日期：</label>
      <input class="itxt" type="text" placeholder="请输入日期"
             autocomplete="off" tabindex="1" name="date"
      <%--									   value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/>--%>
             value="${requestScope.date}"/>
      <input type="submit" value="查询" id="sub_btn" />
      <label>营业额：</label>
      <input class="itxt" type="text" placeholder=""
             autocomplete="off" tabindex="1" name="sum"
      <%--									   value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/>--%>
             value="${requestScope.sum}"/>
    </form>
  </div>


  <table>
    <tr>
      <td>衣物id</td>
      <td>衣物数量</td>
      <td>会员id</td>
      <td>负责店员</td>
      <td>日期</td>
      <td>衣物类型</td>
    </tr>
    <c:forEach items="${requestScope.clist}" var="clothes">
      <tr>
        <td>${clothes.cid}</td>
        <td>${clothes.ccount}</td>
        <td>${clothes.mid}</td>
        <td>${clothes.aid}</td>
        <td>${clothes.date}</td>
        <td>${clothes.tid}</td>
        <td>
          <a href="clothesServlet?action=getClothes&cid=${clothes.cid}&ccount=${clothes.ccount}
                    &mid=${clothes.mid}&aid=${clothes.aid}&date=${clothes.date}&tid=${clothes.tid}">修改</a>
        </td>
        <td>
          <a href="clothesServlet?action=delete&cid=${clothes.cid}">删除</a>
        </td>
      </tr>
    </c:forEach>
    <tr>
      <td></td>
      <td></td>>
      <td></td>>
      <td><a href="pages/clothes/clothes_edit.jsp">添加</a></td>
    </tr>
  </table>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>

