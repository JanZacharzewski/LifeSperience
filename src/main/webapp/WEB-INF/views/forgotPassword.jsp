<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: juanzachariasz
  Date: 27.09.2019
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <title>Forgot Password</title> </head>
<body>
<center>
    <form action="#"  th:th:action="@{/forgot-password}" th:object="${user}" method="post">
        <table>
            <tr>
                <td><%--@declare id="emailid"--%><label for="emailId">Email</label></td>
                <td><input th:field="*{emailId}" type="text" name="emailId"/></td>
            </tr>
            <tr>
                <td><input type="reset" value="Clear"/></td>
                <td><input type="submit" value="Reset Password"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>