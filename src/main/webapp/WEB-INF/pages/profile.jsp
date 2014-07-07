<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="baseURL"
       value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}"/>
<c:set var="URL" value="${requestScope['javax.servlet.forward.request_uri']}"/>

<div class="container">
    <div class="row" style="border-bottom: #000600 1px dashed">
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <img src="http://lorempixel.com/100/100" alt="" class="img-circle img-responsive">
        </div>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <h2>
                <i class="fa fa-user"></i> ${user.username}
                <c:if test="${not empty personal}">
                    <small><spring:message code="label.you"/></small>
                </c:if>
            </h2>
            <p>
                <a href="#" id="up" class="vote"><span class="text-success"><i class="fa fa-thumbs-o-up"></i> <span id="upNumber">${up}</span></span></a> ~
                <a href="#" id="down" class="vote"><span class="text-danger"><i class="fa fa-thumbs-o-down"></i> <span id="downNumber">${down}</span></span></a>
            </p>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <h3><spring:message code="user.info"/> :</h3>
            <dl class="dl-horizontal">
                <dt><spring:message code="registration.date"/></dt>
                <dd><fmt:formatDate value="${user.creationTime}" type="both"/></dd>
                <dt><spring:message code="number.of.ads"/></dt>
                <dd>${fn:length(user.ads)}</dd>
            </dl>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <h2>Services
                <c:if test="${personal}">
                    <a href="/ad/create">
                        <button class="btn btn-default btn-xs"><spring:message code="label.button.create.ad"/></button>
                    </a>
                </c:if>
            </h2>
            <table class="table table-striped">
                <c:forEach items="${user.ads}" var="ad">
                    <tr>
                        <td><a href="/ad/${ad.id}">${fn:substring(ad.title,0,50)}</a></td>
                    </tr>
                    <%--<c:forEach items="${ad}" var="tag">--%>
                    <%--${tag},--%>
                    <%--</c:forEach>--%>
                </c:forEach>
            </table>
        </div>

        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <h2><spring:message code="label.comments"/> </h2>

            <div class="row">

            </div>
        </div>
    </div>
</div>
