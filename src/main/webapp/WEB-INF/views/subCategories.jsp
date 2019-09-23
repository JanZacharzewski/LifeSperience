<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 22.09.2019
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Podkategorie:
<c:forEach items="${subCategories}" var="category">
    ${category.name}
</c:forEach>
</body>
</html>
