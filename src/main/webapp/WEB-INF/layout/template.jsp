<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
    <tiles:insertAttribute name="meta"/>
    <tilesx:useAttribute id="list" name="cssList" classname="java.util.List" ignore="true"/>
    <c:forEach var="item" items="${list}">
        <link rel="stylesheet" href="${item}">
    </c:forEach>
</head>
<body>

<tiles:insertAttribute name="menu"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>

<tilesx:useAttribute id="list" name="jsList" classname="java.util.List" ignore="true" />
<c:forEach var="item" items="${list}">
    <script type="text/javascript" src="${item}"></script>
</c:forEach>
</body>
</html>
