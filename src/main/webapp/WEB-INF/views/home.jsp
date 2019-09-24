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
<%@include file="fragments/header.jspf" %>

<sec:authorize access="hasRole('USER')">
    <%@include file="fragments/userDash.jspf"%>
</sec:authorize>


</body>
</html>
