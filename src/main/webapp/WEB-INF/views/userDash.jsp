<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 24.09.2019
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row">
    <div class="col-lg-5">
        <div class="media">
            <div class="media-body">
                <h4 class="media-heading" style="color: #F8D00C">${user.username}</h4>
                <h5 style="color:#F8D00C">Lvl: ${user.lvl.lvl_value}</h5>
                <h5 style="color:#F8D00C">XP: (${user.lvl.XP_owned}/${user.lvl.XP_needed})</h5>
                <hr style="margin:8px auto">
            </div>
        </div>
    </div>
</div>
<div class="row  mx-auto">
    <div class="col">
        <a class="nav-link btn btn-warning" href="/user/goal/add">Dodaj nowy cel</a>
    </div>
</div>


<div class="container" style="background-color: #05030C">
    <div class="row">
        <div class="col">
            <div class="card mt-4" style="background-color: lavenderblush">
                <div class="card-body">
                    <div class="row">
                        <div class="col align-middle" style="text-align: center">
                            <h1>Twoje aktywne cele:</h1>
                        </div>
                    </div>
                    <table>
                        <thead>
                        <tr>
                            <th>Nazwa celu</th>
                            <th>Kategoria celu</th>
                            <th>Zadanie do wykonania</th>
                            <th>XP do zdobycia</th>
                            <th>Deadline</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        <c:forEach items="${user.activeGoals}" var="goal">
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
                                <td>${goal.deadline}</td>
                                <td><a class="btn btn-warning" href="#" onclick="confirmClose(${goal.id}, '${goal.name}')">Zakończ cel</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<%--</body>--%>
<%--</html>--%>
