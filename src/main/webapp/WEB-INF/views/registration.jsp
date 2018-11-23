<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kd
  Date: 23.11.18
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja uzytkowanika</title>

</head>
<body>

<table>
    <tbody>
    <form:form modelAttribute="registrationFormData" method="post">
        <tr>
            <td>Login: </td>
            <td><form:input path="login"/><form:errors path="login"/> </td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email" type = "email"/><form:errors path="email"/></td>
        </tr>
        <tr>
            <td>Hasło:</td>
            <td><form:password path="password" /><form:errors path="password"/></td>
        </tr>
        <tr>
            <td>Powtórz hasło:</td>
            <td><form:password path="confirmPassword"/><form:errors path="confirmPassword"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="submit" value="WYŚLIJ"></td>
        </tr>
    </form:form>
    </tbody>
</table>
<div><a href="/">powrót</a></div>

</body>
</html>
