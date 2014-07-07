<%--
  Created by IntelliJ IDEA.
  User: saniaky
  Date: 7/7/14
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2><spring:message code="ad.update"/></h2>

    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form:form modelAttribute="adDTO" method="post" enctype="multipart/form-data" role="form"
                       action="/ad/update/${id}">

                <%-- TITLE --%>
                <div class="form-group">
                    <label><spring:message code="label.ad.title"/></label>
                    <form:input path="title" cssClass="form-control"/>
                    <form:errors path="title"/>
                </div>

                <%-- TEXT --%>
                <div class="form-group">
                    <label><spring:message code="label.ad.text"/></label>
                    <form:textarea path="text" cssClass="form-control" id="edit"/>
                    <form:errors path="text"/>
                </div>

                <%-- TAGS--%>
                <div class="form-group">
                    <label><spring:message code="label.ad.tags"/></label><br>
                    <form:select path="tags" multiple="" data-role="tagsinput" items="${adDTO.tags}"/>
                    <form:errors path="tags"/>
                </div>

                <%-- IMAGES --%>
                <div class="form-group">
                    <input type="file" name="images">
                    <form:errors path="images"/>
                </div>
                <div class="form-group">
                    <input id="addBtn" type="button" class="btn btn-default"
                           value="<spring:message code="label.button.add"/>">
                    <input id="removeBtn" type="button" class="btn btn-default"
                           value="<spring:message code="label.button.remove"/>">
                </div>

                <input type="submit" value="<spring:message code="label.button.update.ad"/>"
                       class="btn btn-primary pull-right"/>
            </form:form>
        </div>
    </div>
</div>