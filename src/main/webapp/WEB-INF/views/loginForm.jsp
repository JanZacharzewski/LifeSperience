<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>" rel="stylesheet"
          id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="<c:url value="/resources/css/loginForm.css"/>" rel="stylesheet">
    <title>Title</title>
    <!------ Include the above in your HEAD tag ---------->

</head>
<body id="LoginForm">
<%@include file="fragments/header.jspf" %>
<div class="container">
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>Logowanie</h2>
                <p>Wpisz swoją nazwę użytkownika i hasło</p>
            </div>


            <form id="Login" method="post">
                <c:if test="${not empty errorMessage}">
                    <div align="center" style="color: #ff511d; font-weight: bold;">${errorMessage}</div>
                </c:if>
                <div class="form-group">


                    <label for="inputEmail"></label>
                    <input type="text" class="form-control" id="inputEmail" name="username" placeholder="Username">

                </div>

                <div class="form-group">

                    <label for="inputPassword"></label>
                    <input type="password" class="form-control" id="inputPassword" name="password"
                           placeholder="Password">

                </div>
<%--                <div class="forgot">--%>
<%--                    <a href="/forgot-password">Zapomniałeś hasła?</a>--%>
<%--                </div>--%>
                <div><input type="submit" class="btn btn-primary" value="Login"></div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>

    </div>
</div>


</body>
</html>