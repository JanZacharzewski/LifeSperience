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
                <h4 class="media-heading">${user.username}</h4>
                <h5>Lvl: ${user.lvl.lvl_value}</h5>
                <h5>XP: (${user.lvl.XP_owned}/${user.lvl.XP_needed})</h5>
                <hr style="margin:8px auto">
            </div>
        </div>
    </div>
</div>


<div class="container mt-5" style="background-color: darkgreen">
    <div class="card mt-4" style="background-color: darkorange">
        <div class="card-body">
            <div class="col-md-8 col-md-offset-2">
                <div class="row border-secondary">
                    <div class="col border-secondary" style="text-align: center">
                        Twoje aktywne cele:
                    </div>
                    <div class="col border-secondary" style="text-align: center">
                        Data wygaśnięcia celu:
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--</body>--%>
<%--</html>--%>
