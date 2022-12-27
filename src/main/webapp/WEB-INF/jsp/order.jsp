<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/template/_head.jsp"/>
<body>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="LocalStrings"/>
<c:import url="/WEB-INF/template/menu/_menu.jsp"/>
<div class="text-center" >

<table class="table table-striped table-bordered table-sm table-th">
                     <caption>Order</caption>
        <tr>
                <th> id </th>
                <th> user_id </th>
                <th> craftsman_id </th>
                <th> text </th>
                <th> price </th>
                <th> status </th>
                <th> feedback_text </th>
                <th> feedback_mark </th>
                </tr>
    <tr>
                <td><c:out value="${ goalOrder.id }" /></td>
                <td><c:out value="${ goalOrder.user_id }" /></td>
                <td><c:out value="${ goalOrder.craftsman_id }" /></td>
                <td><c:out value="${ goalOrder.text }" /></td>
                <td><c:out value="${ goalOrder.price }" /></td>
                <td><c:out value="${ goalOrder.status }" /></td>
                <td><c:out value="${ goalOrder.feedback_text }" /></td>
                <td><c:out value="${ goalOrder.feedback_mark }" /></td>

    </tr>
</table>

 <c:choose>

         <c:when test="${userRole=='Client'}">
         <form method="POST" action="">
                     <input type="hidden" name="command" value="order" />
                     <input type="hidden" name="goalIdOrder" value="${ goalOrder.id }" />
                     feedback_text
                     <input type="text" name="goalOrderFeedback_text" value=""/><br/>
                     goalOrder.feedback_mark
                     <input type="text" name="goalOrderFeedback_mark" value=""/><br/>
                     <input type="submit" value="change"/>
                 </form>


         </c:when>

        <c:when test="${userRole=='Manager'||userRole=='Admin'}">
            <form method="POST" action="">
            <input type="hidden" name="command" value="order" />
            <input type="hidden" name="goalIdOrder" value="${ goalOrder.id }" />
            craftsman_id
            <input type="text" name="goalOrderCraftsman_id" value=""/><br/>
            price
            <input type="text" name="goalOrderPrice" value=""/><br/>
             Status
            <input type="text" name="goalOrderStatus" value=""/><br/>
            <input type="submit" value="change"/>
        </form>
        </c:when>
        <c:when test="${userRole=='Craftsman'}">
                    <form method="POST" action="">
                    <input type="hidden" name="command" value="order" />
                    <input type="hidden" name="goalIdOrder" value="${ goalOrder.id }" />
                     Status
                    <input type="text" name="goalOrderStatus" value=""/><br/>
                    <input type="submit" value="change"/>
                </form>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>



</div>
</body></html>