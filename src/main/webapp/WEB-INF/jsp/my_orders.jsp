<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/template/_head.jsp"/>
<body>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="LocalStrings"/>
<c:import url="/WEB-INF/template/menu/_menu.jsp"/>



<form name="pages" method="POST" action="">
    <input type="hidden" name="command" value="my_orders" />
     <input type="text" name="quantityOrders" value="5"/>
    <input type="submit" value="---"/>
    </form>
<table>
<tr>
        <td> id </td>
        <td> user_id </td>
        <td> craftsman_id </td>
        <td> text </td>
        <td> price </td>
        <td> feedback_text </td>
        <td> feedback_mark </td>
        </tr>
    <c:forEach var="order" items="${orders}" varStatus="status">
        <tr>
        <td><c:out value="${ order.id }" /></td>
        <td><c:out value="${ order.user_id }" /></td>
        <td><c:out value="${ order.craftsman_id }" /></td>
        <td><c:out value="${ order.text }" /></td>
        <td><c:out value="${ order.price }" /></td>
        <td><c:out value="${ order.feedback_text }" /></td>
        <td><c:out value="${ order.feedback_mark }" /></td>
        </tr>
    </c:forEach>
</table>

<br/>

<table>
<tr>
<c:forEach var="page" items="${listPagesOrders}" varStatus="status">
        <form method="POST" action="">
            <input type="hidden" name="command" value="my_orders" />
            <input type="hidden" name="skipOrders" value="${ page }" />
            <input type="submit" value="${ status.count }"/>
        </form>

    </c:forEach>
</tr>
</table>
</body></html>