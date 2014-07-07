<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: saniaky
  Date: 7/6/14
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-12 text-center">
        <h3><i class="fa fa-paragraph"></i> ${ad.title}</h3>
    </div>
</div>

<div style="padding: 10px"></div>

<div class="row">
    <div class="col-sm-4 col-md-4 col-lg-4">
        <ul id="lightSlider" class="list-unstyled">
            <c:forEach items="${ad.images}" var="image">
                <li data-thumb="/assets/uploads/${image}">
                    <img src="/assets/uploads/${image}" alt="img" style="max-height: 300px;">
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
        <p>${ad.text}</p>

        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" style="line-height: 2em;">
                <p><i class="fa fa-tags"></i> Tags:
                    <c:forEach items="${ad.tags}" var="tag">
                        <a href="/tag/${tag}"><span class="label label-primary">${tag}</span></a>
                    </c:forEach>
                </p>
            </div>
        </div>
    </div>

    <div class="col-md-3">
        <c:choose>
            <c:when test="${personal}">
                <h4 class="text-center">Private</h4>
                <p class="text-center">
                    <a href="/ad/edit/${ad.id}"><button class="btn btn-default btn-xs"><s:message code="label.button.edit"/></button></a>
                    <a href="/ad/delete/${ad.id}"><button class="btn btn-default btn-xs"><s:message code="label.button.remove.ad"/></button></a>
                </p>
            </c:when>
            <c:otherwise>
                <h4 class="text-center text-info">Seller information: </h4>
                <dl class="dl-horizontal">
                    <dt>User</dt>
                    <dd><a href="/profile/${ad.user.username}">${ad.user.username}</a></dd>
                    <dt>Registration date</dt>
                    <dd><fmt:formatDate value="${ad.user.creationTime}" type="date"/></dd>
                    <dt>Number of ads</dt>
                    <dd>${fn:length(ad.user.ads)}</dd>
                </dl>
            </c:otherwise>
        </c:choose>
    </div>
</div>
