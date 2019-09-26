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
        <label> Wybierz kategorie swojego celu:
            <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
        </label>
    </div>

    <div>
        <label> Wybierz podkategorie swojego celu:
            <form:select path="category.parent_id" items="${subcategories}" itemLabel="name" itemValue="id"/>
        </label>
    </div>
    <input type="submit" value="Dodaj cel"/>
</form:form>
</body>
</html>
