<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h1><spring:message code="label.login.page.title"/></h1>

    <div class="row">
        <div class="col-md-2 col-md-offset-5">
            <form action="/login" method="post" role="form" id="loginForm" autocomplete="off">
                <c:if test="${param.error == ''}">
                    <span class="help-block has-error"><spring:message code="label.login.error"/></span>
                </c:if>

                <div class="form-group">
                    <label><spring:message code="label.field.username"/></label>
                    <input type="text" name="username" class="form-control">
                </div>

                <div class="form-group">
                    <label><spring:message code="label.field.password"/></label>
                    <input type="password" name="password" class="form-control">
                </div>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" placeholder=""/>

                <button class="btn btn-default" type="submit"><spring:message code="label.login.submit"/></button>
            </form>
        </div>
    </div>
</div>