<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/29
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑会员信息</title>
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
    <span class="wel_word">编辑会员信息</span>
    <%--静态包含 manager管理模块的菜单--%>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <form action="memberServlet?action=update" method="get">
        <input type="hidden" name="action" value="${empty param.id ? "add" : "update"}" />
        <input type="hidden" name="id" value="${requestScope.member.mid}" />
        <table>
            <tr>
                <td>会员id</td>
                <td>会员名字</td>
                <td>会员等级</td>
                <td>会员余额</td>
                <td>店员密码</td>
            </tr>
            <tr>
                <td><input name="id" type="text" value="${requestScope.member.mid}"/></td>
                <td><input name="name" type="text" value="${requestScope.member.mname}"/></td>
                <td><input name="grade" type="text" value="${requestScope.member.grade}"/></td>
                <td><input name="balance" type="text" value="${requestScope.member.balance}"/></td>
                <td><input name="password" type="text" value="${requestScope.member.password}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>

        </table>
    </form>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
