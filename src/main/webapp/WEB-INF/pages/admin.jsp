<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: saniaky
  Date: 7/7/14
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h2><spring:message code="title.admin"/></h2>
    <table class="table table-stripped">
        <c:forEach items="${users}" var="user">
            <tr id="${user.id}">
                <td><a href="/admin/edit/${user.username}">${user.username}</a></td>
                <td class="role">${user.role}</td>
                <td><a href="#" class="deleteBtn">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
</div>