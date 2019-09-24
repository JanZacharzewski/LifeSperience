<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 24.09.2019
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="subcategory">
        <div>
            <label>
                <form:input path="name"/>
            </label>
            <form:errors path="name"/>
        </div>
        <div>
            <label for="subCategoryId">Kategoria: </label>
                <form:select path="parent_id" id="subCategoryId">
                    <c:forEach items="${categories}" var="category">
                        <form:option value="${category.id}" label="${category.name}"/>
                    </c:forEach>
                </form:select>
        </div>
        <input type="submit" value="Zapisz" />
    </form:form>
</body>
</html>
