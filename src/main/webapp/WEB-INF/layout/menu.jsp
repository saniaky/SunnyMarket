<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="URL" value="${requestScope['javax.servlet.forward.request_uri']}" />

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Sunny Market</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/"><i class="fa fa-home"></i> <s:message
                        code="layout.home"/> </a></li>
                <li><a href="/ad/all"><i class="fa fa-paperclip"></i> <s:message code="layout.ads"/> </a></li>
                <li><a href="/users"><i class="fa fa-users"></i> <s:message code="layout.users"/> </a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><s:message code="layout.lang"/> <b
                            class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="?language=en"><img src="<c:url value="/assets/images/eng.png"/>" alt="eng"> <s:message
                                code="layout.lang.english"/></a></li>
                        <li><a href="?language=ru"><img src="<c:url value="/assets/images/rus.png"/>" alt="rus"> <s:message
                                code="layout.lang.russian"/></a></li>
                    </ul>
                </li>

                <c:set var="username" value="${pageContext.request.remoteUser}"/>
                <c:choose>
                    <c:when test="${username != null}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hi, ${username} <b
                                    class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/preferences"><i class="fa fa-cog"></i> <s:message
                                        code="layout.preferences"/> </a></li>
                                <li><a href="/profile/${username}"><i class="fa fa-user"></i> <s:message code="layout.profile"/>
                                </a></li>
                                <li class="divider"></li>
                                <li><a href="/logout"><i class="fa fa-sign-out"></i> <s:message code="layout.logout"/>
                                </a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/login"><s:message code="layout.signin"/> </a></li>
                        <li><a href="/signup"><s:message code="layout.register"/> </a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
            <form class="navbar-form" role="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="<s:message code="layout.search"/> ">
            <span class="input-group-btn">
              <button type="submit" class="btn btn-default">
                <span class="glyphicon glyphicon-search">
                  <span class="sr-only"><s:message code="layout.search"/> </span>
                </span>
              </button>
            </span>
                </div>
            </form>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>