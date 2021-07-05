<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/30
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑价目表</title>
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
    <span class="wel_word">编辑价目表</span>
    <%--静态包含 manager管理模块的菜单--%>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <form action="typeServlet?action=update" method="get">
        <input type="hidden" name="action" value="${empty param.id ? "add" : "update"}" />
        <input type="hidden" name="id" value="${requestScope.type.tid}" />
        <table>
            <tr>
                <td>衣物类型id</td>
                <td>衣物类型名</td>
                <td>衣物类型单价</td>
            </tr>
            <tr>
                <td><input name="id" type="text" value="${requestScope.type.tid}"/></td>
                <td><input name="name" type="text" value="${requestScope.type.tname}"/></td>
                <td><input name="price" type="text" value="${requestScope.type.unitprice}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>

        </table>
    </form>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
