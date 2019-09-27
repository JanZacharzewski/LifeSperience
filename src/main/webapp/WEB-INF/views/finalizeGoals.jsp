<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 27.09.2019
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wykonane cele</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        function confirmClose(id, name) {
            if (confirm("Czy na pewno chcesz zakończyć cel '" + name + "'?")) {
                window.location.href = "/user/goal/close/" + id;
            }
        }
    </script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="../../css/editor.css" rel="stylesheet">
</head>
<body>
<%@include file="fragments/header.jspf" %>
<div class="container" style="background-color: #05030C">
    <div class="row">
        <div class="col">
            <div class="card mt-4" style="background-color: lavenderblush">
                <div class="card-body">
                    <div class="row">
                        <div class="col align-middle" style="text-align: center">
                            <h1>Twoje zakończone cele:</h1>
                        </div>
                    </div>
                    <table>
                        <thead>
                        <tr>
                            <th>Nazwa celu</th>
                            <th>Kategoria celu</th>
                            <th>Zadania, które wykonałeś</th>
                            <th>XP, które zdobyłeś</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        <c:forEach items="${user.closeGoals}" var="goal">
                            <tr>
                                <td>${goal.name}</td>
                                <td>${goal.category.name}</td>
                                <td><ul>
                                    <c:forEach items="${goal.exercises}" var="ex">
                                        <li>${ex.name}</li>
                                    </c:forEach>
                                </ul>
                                </td>
                                <td>${goal.xp_to_get}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
