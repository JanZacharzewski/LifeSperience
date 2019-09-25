<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 20.09.2019
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>

<%@include file="fragments/header.jspf" %>

<sec:authorize access="hasRole('USER')">
    <%@include file="userDash.jsp"%>
</sec:authorize>


</body>
</html>
