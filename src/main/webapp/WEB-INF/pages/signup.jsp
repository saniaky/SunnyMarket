<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: saniaky
  Date: 7/2/14
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Create User</h1>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form:form method="post" modelAttribute="signupDTO">

            <s:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label"><s:message code="label.field.username"/></label>
                    <form:input path="username" class="form-control"/>
                    <span class="help-block"><form:errors path="username"/></span>
                </div>
            </s:bind>

            <s:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label"><s:message code="label.field.password"/></label>
                    <form:password path="password" class="form-control"/>
                    <span class="help-block"><form:errors path="password"/></span>
                </div>
            </s:bind>

            <s:bind path="confirmPassword">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label"><s:message code="label.field.password.repeat"/></label>
                    <form:password path="confirmPassword" class="form-control"/>
                    <span class="help-block"><form:errors path="confirmPassword"/></span>
                </div>
            </s:bind>

            <div align="right">
                <input type="submit" value="<s:message code="label.login.submit"/>" class="btn btn-info"/>
            </div>

        </form:form>
    </div>
</div>