<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 25.09.2019
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie Celu</title>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="fragments/header.jspf" %>
<form:form modelAttribute="goal" method="post">
    <div>
        <label> Nazwa celu:
            <form:input path="name"/>
        </label>
    </div>

    <div>
        <label> Ustaw deadline:
            <form:input type="date" path="deadline"/>
        </label>
    </div>

    <div>
        <label>Wybierz kategorie swojego celu:
            <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
            <a class="nav-link btn btn-warning" href="#" style="width: fit-content;">Wybierz podkategorie</a>
        </label>
    </div>

    <div>
        <label> Wybierz podkategorie swojego celu:
            <form:select path="category.parent_id" items="${subcategories}" itemLabel="name" itemValue="id"/>
            <a class="nav-link btn btn-warning" href="#" style="width: fit-content">Wybierz zadania</a>
        </label>
    </div>
    <div>
        <label> Wybierz zadania dla swojego celu:
            <form:select path="category">
                <form:options items="${goal.exercises}" itemValue="id" itemLabel="name"/>
            </form:select>
        </label>
    </div>
    <input type="submit" value="Dodaj cel"/>
</form:form>
</body>
</html>
