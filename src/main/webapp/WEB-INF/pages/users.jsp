<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: saniaky
  Date: 7/2/14
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h1><spring:message code="users"/></h1>
    <div class="row">
        <div class="col-md-4">
            <h2><spring:message code="top.upvoted.users"/></h2>
            <table class="table table-responsive table-striped">
                <thead>
                <tr>
                    <td><spring:message code="label.field.username"/></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${upvoted_users}" var="user">
                    <tr>
                        <td><a href="/profile/${user.username}">${user.username}</a></td>
                        <td>
                            <span class="text-success"><i class="fa fa-thumbs-o-up"></i> ${user.likes}</span>
                            <span class="text-danger"><i class="fa fa-thumbs-o-down"></i> ${user.dislikes}</span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="col-md-4">
            <h2><spring:message code="top.downvoted.users"/></h2>
            <table class="table table-responsive table-striped">
                <thead>
                <tr>
                    <td><spring:message code="label.field.username"/></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${downvoted_users}" var="user">
                    <tr>
                        <td><a href="/profile/${user.username}">${user.username}</a></td>
                        <td>
                            <span class="text-success"><i class="fa fa-thumbs-o-up"></i> ${user.likes}</span>
                            <span class="text-danger"><i class="fa fa-thumbs-o-down"></i> ${user.dislikes}</span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="col-md-4">
            <h2><spring:message code="newbies"/></h2>
            <table class="table table-responsive table-striped">
                <thead>
                <tr>
                    <td><spring:message code="label.field.username"/></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${recent_users}" var="user">
                    <tr>
                        <td><a href="/profile/${user.username}">${user.username}</a></td>
                        <td><fmt:formatDate value="${user.creationTime}" type="BOTH"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>