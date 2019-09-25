<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 25.09.2019
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="exercise">
        <div>
            <label> Nazwa:
                <form:input path="name"/>
            </label>
            <form:errors path="name"/>
        </div>
        <div>
            <label> XP do zdobycia:
                <form:input type="number" path="EXP_to_gain"/>
            </label>
            <form:errors path="EXP_to_gain"/>
        </div>
        <div>
            <label> Poziom trudności:
                <form:select path="difficulty.id" items="${difficulties}" itemLabel="difficulty" itemValue="id"/>
            </label>
        </div>
        <div>
            <label> Kategoria:
                <form:select path="category.id" items="${subcategories}" itemLabel="name" itemValue="id"/>
            </label>
        </div>
        <input type="submit" value="Send">
    </form:form>
</body>
</html>
