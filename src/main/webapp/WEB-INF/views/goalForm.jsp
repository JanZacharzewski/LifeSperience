<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="fragments/header.jspf" %>
<form:form modelAttribute="goal" method="post">
    <div class="container" style="text-align: center; color: #F8D00C">
        <div class="row">
            <div class="col">


                <div class="container mx-auto">
                    <div class="row">
                        <div class="col">
                            <div class="form-group" style="width: 50%">
                                <label for="exampleFormControlInput1">Nazwa celu</label>
                                <form:input path="name" type="text" class="form-control" id="exampleFormControlInput1"
                                            placeholder="Nazwa celu"/>
                            </div>

                            <div class="form-group" style="width: 50%">
                                <label for="exampleFormControlInput1">Ustaw deadline</label>
                                <form:input path="deadline" type="date" class="form-control"
                                            id="exampleFormControlInput1"
                                            placeholder="Data zakończenia celu"/>
                            </div>

                            <div class="row" style="margin-top:50px;">
                                <div class="col-md-4 mx-auto col-12">
                                    <div class="b-select-wrap">
                                        Wybierz kategorie swojego celu:
                                        <form:select cssClass="form-control b-select" path="category.id"
                                                     items="${categories}"
                                                     itemLabel="name"
                                                     itemValue="id"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="container">
                            <div class="row" style="margin-top:50px;">
                                <div class="col-md-4 mx-auto col-12">
                                    <div class="b-select-wrap">
                                        Wybierz podkategorie swojego celu:
                                        <form:select cssClass="form-control b-select" path="category.parent_id"
                                                     items="${subcategories}"
                                                     itemLabel="name" itemValue="id"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="container">
                            <div class="row" style="margin-top:50px;">
                                <div class="col-md-4 mx-auto col-12">
                                    <div class="b-select-wrap">
                                        Wybierz zadania swojego celu:
                                        <form:select path="exercises">
                                            <form:options cssClass="form-control b-select" items="${exercises}"
                                                          itemValue="id"
                                                          itemLabel="name_exp"/>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div><input type="submit" class="nav-link btn btn-warning" value="Dodaj cel"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form:form>
</body>
</html>
