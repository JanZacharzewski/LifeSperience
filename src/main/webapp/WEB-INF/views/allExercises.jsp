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


<div class="container mt-5 mx-auto">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="table table-dark">
                <div class="row">
                    <div class="col" style="color:darkorange">Id</div>
                    <div class="col" style="text-align:center; color:darkorange">Nazwa</div>
                    <div class="col" style="text-align:center; color:darkorange">XP do zdobycia</div>
                    <div class="col" style="text-align:center; color:darkorange">Kategoria</div>
                </div>

                <c:forEach items="${exercises}" var="exercise" varStatus="id">
                    <div class="row">
                        <div class="col">${id.count}</div>
                        <div class="col" style="text-align: center">${exercise.name}</div>
                        <div class="col" style="text-align: center">${exercise.EXP_to_gain}</div>
                        <div class="col" style="text-align: center">${exercise.category.name}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div>
        <div class="card-body">
            <a href="<c:url value="/admin/subCategory/add"/>" class="btn btn-primary">Dodaj nowe zadanie</a>
        </div>
    </div>
</div>
</body>
</html>