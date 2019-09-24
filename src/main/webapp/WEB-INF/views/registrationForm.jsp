<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 23.09.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:form method="post" modelAttribute="user">
    <div>
        <label>
            Login: <c:input path="userName"/>
        </label>
        <c:errors path="userName"/>
    </div>
    <div>
        <label>
            Hasło: <c:input path="password" type="password"/>
        </label>
        <c:errors path="password"/>
    </div>
    <div>
        <label>
            Email: <c:input path="email" type="email"/>
        </label>
        <c:errors path="email"/>
    </div>
    <input type="submit">
</c:form>
</body>
</html>
