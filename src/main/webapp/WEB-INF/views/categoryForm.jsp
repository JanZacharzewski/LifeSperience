<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 24.09.2019
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<p class="error" style="color:red">${error.defaultMessage}</p>
<c:form method="post" modelAttribute="category">
    <div>
        <label> Nazwa kategorii:
            <c:input path="name"/>
        </label>
        <form:errors path="name"/>
    </div>
    <input type="submit" value="Add Category">
</c:form>
</body>
</html>
