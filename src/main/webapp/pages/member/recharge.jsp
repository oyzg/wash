<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/7/3
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>充值</title>
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
    <span class="wel_word">充值</span>
    <%--静态包含 manager管理模块的菜单--%>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <div class="form">
        <form action= "memberServlet" method="post">
            <input type="hidden" name="action" value="recharge">
            <label>金额：</label>
            <input class="itxt" type="text" placeholder="请输入金额"
                   autocomplete="off" tabindex="1" name="money"
            <%--									   value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/>--%>
                   value="100"/>
            <input type="submit" value="充值" id="sub_btn" />

        </form>
    </div>


</div>

<%--	静态包含 页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
