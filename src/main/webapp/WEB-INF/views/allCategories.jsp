<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 24.09.2019
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>

<%@include file="fragments/header.jspf" %>


<div class="container mt-5">
    <div class="col-md-8 col-md-offset-5">
        <div class="table table-dark">
            <div class="row mx-auto">
                <div class="col align-middle" style="text-align: center">Id</div>
                <div class="col align-middle" style="text-align: center">Name</div>
            </div>

            <c:forEach items="${categories}" var="category" varStatus="id">
                <div class="row mx-auto">
                    <div class="col align-middle" style="text-align: center">${id.count}</div>
                    <div class="col align-middle" style="text-align: center">${category.name}</div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div>
        <div class="card-body">
            <a href="/admin/category/add" class="btn btn-primary">Add new category!</a>
        </div>
    </div>
</div>
</body>
</html>
