<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/30
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>编辑衣物信息</title>
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

    input {
      text-align: center;
    }
  </style>
</head>
<body>
<div id="header">
  <img class="logo_img" alt="" src="../../static/img/logo.gif" >
  <span class="wel_word">编辑衣物信息</span>
  <%--静态包含 manager管理模块的菜单--%>
<%--  <%@include file="/pages/common/manager_menu.jsp"%>--%>
</div>

<div id="main">
  <form action="clothesServlet?action=update" method="get">
    <input type="hidden" name="action" value="${empty param.cid ? "add" : "update"}" />
    <input type="hidden" name="cid" value="${requestScope.clothes.cid}" />
    <table>
      <tr>
        <td>衣物id</td>
        <td>衣物数量</td>
        <td>物主</td>
        <td>负责店员</td>
        <td>日期</td>
        <td>衣物类型</td>
      </tr>
      <tr>
        <td><input name="id" type="text" value="${requestScope.clothes.cid}"/></td>
        <td><input name="count" type="text" value="${requestScope.clothes.ccount}"/></td>
        <td><input name="mid" type="text" value="${requestScope.clothes.mid}"/></td>
        <td><input name="aid" type="text" value="${requestScope.clothes.aid}"/></td>
        <td><input name="date" type="text" value="${requestScope.clothes.date}"/></td>
        <td><input name="tid" type="text" value="${requestScope.clothes.tid}"/></td>
        <td><input type="submit" value="提交"/></td>
      </tr>

    </table>
  </form>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
