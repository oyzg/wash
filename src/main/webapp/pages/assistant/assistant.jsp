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
			<span class="wel_word">我的店员</span>
		<%-- 静态包含，登录成功之后的菜单 --%>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">

		<div class="form">
			<form action= "assistantServlet" method="post">
				<input type="hidden" name="action" value="findById">
				<label>编号：</label>
				<input class="itxt" type="text" placeholder="请输入编号"
					   autocomplete="off" tabindex="1" name="id"
				<%--									   value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/>--%>
					   value="${requestScope.id}"/>
				<input type="submit" value="查询" id="sub_btn" />
				<label>业绩：</label>
				<input class="itxt" type="text" placeholder=""
					   autocomplete="off" tabindex="1" name="sum"
				<%--									   value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/>--%>
					   value="${requestScope.sum}"/>
			</form>

		</div>

		<table>
			<tr>
				<td>店员id</td>
				<td>店员名字</td>
				<td>店员密码</td>
			</tr>
			<c:forEach items="${requestScope.alist}" var="assistant">
				<tr>
					<td>${assistant.aid}</td>
					<td>${assistant.aname}</td>
					<td>${assistant.password}</td>
					<td>
						<a href="assistantServlet?action=getAssistant&id=${assistant.aid}&name=${assistant.aname}&password=${assistant.password}">修改</a>
					</td>
					<td>
						<a href="assistantServlet?action=delete&aid=${assistant.aid}">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>>
				<td></td>>
				<td><a href="pages/assistant/assistant_edit.jsp">添加员工</a></td>
			</tr>
		</table>
		
	
	</div>

	<%--	静态包含 页脚内容 --%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>