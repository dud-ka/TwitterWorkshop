<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kd
  Date: 23.11.18
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>

<table>
    <tbody>
    <form:form modelAttribute="loginFormData" method="post">
    <tr>
        <td>Login: </td>
        <td><form:input path="login" /><form:errors path="login"/> </td>
    </tr>
    <tr>
        <td>Hasło: </td>
        <td><form:password path="password"/><form:errors path="password"/></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value=ZALOGUJ></td>

    </tr>
    </form:form>
    </tbody>

</table>
<div><a href="/">Powrót</a></div>

</body>
</html>
