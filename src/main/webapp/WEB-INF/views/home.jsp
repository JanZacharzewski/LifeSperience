<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 20.09.2019
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sec:authorize access="hasAnyRole('ADMIN', 'USER')">
    <%@include file="fragments/header.jspf" %>
</sec:authorize>
<h1>HOME</h1>
<sec:authorize access="isAuthenticated()">
    <h1>HOME2</h1>
    <form method="post" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" class="btn btn-primary" value="Logout"/>
    </form>
</sec:authorize>
</body>
</html>
