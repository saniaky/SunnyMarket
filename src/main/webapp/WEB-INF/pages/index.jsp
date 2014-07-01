<%--
  Created by IntelliJ IDEA.
  User: saniaky
  Date: 6/25/14
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="bg"></div>
<div class="jumbotron">
    <h1><s:message code="message.welcome"/></h1>
    <p class="lead">Public your service right now!</p>
</div>


<div class="container content">
    <div class="page-header">
        <h1><i class="fa fa-paragraph"></i><s:message code="message.ad.header"/> <small><s:message code="message.ad.subtext"/></small></h1>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="col-md-5">
                <img src="http://lorempixel.com/100/100" alt="" class="img-responsive img-thumbnail">
            </div>
            <div class="col-md-7">
                <p class="title"><a href="#">Cleaning your ass</a></p>
                <p>Here goes a description of some service. lorem</p>
                <p>by <a href="#">Naginator</a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="col-md-5">
                <img src="http://lorempixel.com/100/100" alt="" class="img-responsive img-thumbnail">
            </div>
            <div class="col-md-7">
                <p class="title"><a href="#">Helping with hiding dead bodies</a></p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores neque ab reiciendis commodi autem, quis ipsa voluptatem excepturi facilis libero voluptas minus alias deserunt a, sequi earum quasi ipsum molestias.</p>
                <p>by <a href="#">hitman</a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="col-md-5">
                <img src="http://lorempixel.com/100/100" alt="" class="img-responsive img-thumbnail">
            </div>
            <div class="col-md-7">
                <p class="title"><a href="#">Some trash goes here.</a></p>
                <p>Here goes a description of some service. lorem</p>
                <p>by <a href="#">zhopinator</a>
            </div>
        </div>
    </div>



    <div class="page-header">
        <h1><i class="fa fa-users"></i><s:message code="message.sellers.header"/> <small><s:message code="message.sellers.subtext"/></small></h1>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="col-md-5">
                <img src="http://lorempixel.com/200/200" alt="" class="img-responsive img-circle">
            </div>
            <div class="col-md-7">
                <p class="title"><a href="#">Cleaning your ass</a></p>
                <p>Here goes a description of some service. lorem</p>
                <p>by <a href="#">Naginator</a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="col-md-5">
                <img src="http://lorempixel.com/200/200" alt="" class="img-responsive img-circle">
            </div>
            <div class="col-md-7">
                <p class="title"><a href="#">Helping with hiding dead bodies</a></p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores neque ab reiciendis commodi autem, quis ipsa voluptatem excepturi facilis libero voluptas minus alias deserunt a, sequi earum quasi ipsum molestias.</p>
                <p>by <a href="#">hitman</a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="col-md-5">
                <img src="http://lorempixel.com/200/200" alt="" class="img-responsive img-circle">
            </div>
            <div class="col-md-7">
                <p class="title"><a href="#">Some trash goes here.</a></p>
                <p>Here goes a description of some service. lorem</p>
                <p>by <a href="#">zhopinator</a>
            </div>
        </div>
    </div>


    <div class="page-header">
        <h1><i class="fa fa-tags"></i> <s:message code="message.tags.header"/> <small><s:message code="message.tags.subtext"/> </small></h1>
    </div>
    <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <div class="col-sm-4 col-md-4 tag-search">
                <div class="input-group">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                </div><!-- /input-group -->
            </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" style="line-height: 2em;">
            <a href="#"><span class="label label-default">C++</span></a>
            <a href="#"><span class="label label-primary">Books</span></a>
            <a href="#"><span class="label label-success">Alergo</span></a>
            <a href="#"><span class="label label-info">Zhirik</span></a>
            <a href="#"><span class="label label-warning">Anus sex</span></a>
            <a href="#"><span class="label label-danger">Danger</span></a>
            <a href="#"><span class="label label-default">C++</span></a>
            <a href="#"><span class="label label-primary">Books</span></a>
            <a href="#"><span class="label label-success">Alergo</span></a>
            <a href="#"><span class="label label-info">Zhirik</span></a>
            <a href="#"><span class="label label-warning">Anus sex</span></a>
            <a href="#"><span class="label label-danger">Danger</span></a>
        </div>
    </div> <!-- row about tags -->

</div> <!-- content -->
<h2>Today is : ${today}</h2>

<c:forEach items="${users}" var="user">
    <p>${user.username} - ${user.password}</p>
</c:forEach>