<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row" style="border-bottom: #000600 1px dashed">
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <img src="http://lorempixel.com/100/100" alt="" class="img-circle img-responsive">
        </div>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <h2><i class="fa fa-user"></i> ${pageContext.request.remoteUser}</h2>
            <p><input id="input-rating" value="${user.rating}" type="number" class="rating" min="0" max="5" step="0.5" data-size="xs"></p>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <h3>Info:</h3>
            <dl class="dl-horizontal">
                <dt>BDay</dt>
                <dd>12/12/99</dd>
                <dt>Sex</dt>
                <dd>Men</dd>
                <dt>Number of ads</dt>
                <dd>32</dd>
            </dl>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <h2>Reviews</h2>
            <div class="row">

            </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <h2>Services</h2>
        </div>
    </div>
</div>