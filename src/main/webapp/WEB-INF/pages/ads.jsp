<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: saniaky
  Date: 7/7/14
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h2><spring:message code="all.ads"/></h2>
    <c:forEach items="${ads}" var="ad">
        <div class="row" style="border-bottom: 1px black dashed">
            <h4>
                <c:if test="${not empty ad.images[0]}">
                    <img src="/assets/uploads/${ad.images[0]}" style="max-height: 100px" class="img-thumbnail">
                </c:if>
                <a href="/ad/${ad.id}">${ad.title}</a>
                <small>by <a href="/profile/${ad.user.username}">${ad.user.username}</a></small>
            </h4>
            <p>${ad.text}</p>
        </div>
    </c:forEach>

</div>