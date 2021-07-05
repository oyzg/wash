<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>洗衣店首页</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
	<%--<script type="text/javascript" >
		$(function () {
			// 给加入购物车按钮绑定单击事件
			$("button.addToCart").click(function () {
				/**
				 * 在事件响应的function函数 中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
				 * @type {jQuery}
				 */
				var bookId = $(this).attr("bookId");
				// location.href = "http://localhost:8080/book/cartServlet?action=addItem&id=" + bookId;
				$.getJSON("http://localhost:8080/book/cartServlet","action=ajaxAddItem&id="+ bookId,function (data) {
					console.log(data);
					$("#cartTotalCount").text("您的购物车中有"+data.totalCount+"件商品");
					$("#lastName").text("您刚刚将"+data.lastName+"加入到了购物车中");
				});
			});
		});
	</script>--%>

</head>
<body>

<div id="header">
<%--	<img class="logo_img" alt="" src="static/img/logo.gif" >--%>

	<span class="wel_word">洗衣店</span>
	<div>
		<c:if test="${empty sessionScope.member and empty sessionScope.assistant}">
			<a href="pages/user/login.jsp">登录</a> |
			<a href="pages/user/regist.jsp">注册</a>
		</c:if>
		<c:if test="${not empty sessionScope.member}">
			<span>欢迎<span class="um_span">${sessionScope.member.mname}</span>光临洗衣店</span>
			<a href="clothesServlet?action=findByMid&mid=${sessionScope.member.mid}">我的订单</a>
			<a href="memberServlet?action=logout">注销</a>
		</c:if>
		<c:if test="${not empty sessionScope.assistant}">
			<span>欢迎<span class="um_span">${sessionScope.assistant.aname}</span>光临洗衣店</span>
			<a href="assistantServlet?action=logout">注销</a>
		</c:if>
		 &nbsp;&nbsp;
<%--		<a href="pages/cart/cart.jsp">购物车</a>--%>
		<a href="pages/manager/manager.jsp">后台管理</a>

	</div>
</div>

<div id="main">

	<table>
		<tr>
			<td>
				<a href="typeServlet?action=list">价目表</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="clothesServlet?action=findByMid&mid=${sessionScope.member.mid}">查询我的衣物</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="pages/clothes/clothes_edit.jsp">下单</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="pages/member/recharge.jsp">充值</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="memberServlet?action=findById&id=${sessionScope.member.mid}">我的信息</a>
			</td>
		</tr>
	</table>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>