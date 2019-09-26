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
                <h4 class="media-heading" style="color: forestgreen">${user.username}</h4>
                <h5 style="color:forestgreen">Lvl: ${user.lvl.lvl_value}</h5>
                <h5 style="color:forestgreen">XP: (${user.lvl.XP_owned}/${user.lvl.XP_needed})</h5>
                <hr style="margin:8px auto">
            </div>
        </div>
    </div>
</div>
<div class="row  mx-auto">
    <div class="col">
        <a class="nav-link btn btn-primary" href="user/goal/add">Dodaj nowy cel</a>
    </div>
</div>


<div class="container" style="background-color: ivory">
    <div class="row">
        <div class="col">
            <div class="card mt-4" style="background-color: darkorange">
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
                            <th>XP do zdobycia</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        <c:forEach items="${user.goals}" var="goal">
                            <tr>
                                <td>${goal.name}</td>
                                <td>${goal.category.name}</td>
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

<%--</body>--%>
<%--</html>--%>
