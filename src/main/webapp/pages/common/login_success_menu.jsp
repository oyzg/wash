<%--
  Created by IntelliJ IDEA.
  User: oyzg
  Date: 2021/6/1
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div>
    <c:if test="${not empty sessionScope.member}">
        <span>欢迎<span class="um_span">${sessionScope.member.mname}</span>光临洗衣店</span>
    </c:if>
    <c:if test="${not empty sessionScope.assistant}">
        <span>欢迎<span class="um_span">${sessionScope.assistant.aname}</span>光临洗衣店</span>
    </c:if>
<%--    <span>欢迎<span class="um_span">${empty sessionScope.member ? empty sessionScope.assistant ? }</span>光临洗衣店</span>--%>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
