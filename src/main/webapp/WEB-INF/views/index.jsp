<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Michał Kupisiński
  Date: 23.11.2018
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pl.coderslab.tweeter.web.controllers.LoginController" %>
<html>
<head>
    <title>Tweeter 2.0</title>
</head>
<body>
<div>
    <c:if test="${loggedUser != null}">
        <p>Zalogowany użytkownik: ${loggedUser.login} <a href="/logout">WYLOGUJ</a></p>
    </c:if>
</div>

<h1>${title}</h1>
<div><a href="/registration">rejestracja</a></div>
<div><a href="/login">logowanie</a></div>

</body>
</html>
