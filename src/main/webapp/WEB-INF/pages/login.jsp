<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<div id="login-box">--%>
<%--<h3><spring:message code="label.login.form.title"/></h3>--%>
<%--<c:if test="${param.error == ''}">--%>
<%--<div class="error"><spring:message code="text.login.page.login.failed.error"/></div>--%>
<%--</c:if>--%>
<%--<c:if test="${ msg}">--%>
<%--<div class="msg">${msg}</div>--%>
<%--</c:if>--%>

<%--<form name='loginForm' action="/login" method='POST'>--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td><spring:message code="label.field.username"/> :</td>--%>
<%--<td><input type='text' name='username' value=''></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td><spring:message code="label.field.password"/> :</td>--%>
<%--<td><input type='password' name='password'/></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan='2'>--%>
<%--<input name="submit" type="submit" value="<spring:message code="label.login.submit.button"/>"/>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--</form>--%>
<%--</div>--%>

<h2>${error}</h2>

<h2><c:if test="${not empty param.error}">YO!</c:if></h2>
${SPRING_SECURITY_LAST_EXCEPTION.message}
${SPRING_SECURITY_LAST_EXCEPTION.localizedMessage}

<div class="container auth">
    <h1 class="text-center"><s:message code="label.login.form.title"/> <span>Life is good</span></h1>

    <div id="big-form" class="well auth-box">
        <form action="/login" method="post" role="form" id="loginForm">
            <!-- Form Name -->
            <%--<legend>Nice form example</legend>--%>
            <c:if test="${param.error == ''}">
                <div class="alert alert-danger" role="alert"><s:message
                        code="text.login.page.login.failed.error"/></div>
            </c:if>
            <c:if test="${msg}">
                <div class="alert alert-info" role="alert">${msg}</div>
            </c:if>

            <div class="form-group float-label-control">
                <label for="">Username</label>
                <input type="text" name="username" class="form-control"
                       placeholder="<s:message code="label.field.username"/>">
            </div>

            <div class="form-group float-label-control">
                <label for="">Password</label>
                <input type="password" class="form-control" name="password"
                       placeholder="<s:message code="label.field.password"/>">

            </div>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" placeholder=""/>

            <button class="btn btn-default" type="submit"><s:message
                    code="label.login.submit.button"/></button>

        </form>
    </div>
    <div class="clearfix"></div>
</div>