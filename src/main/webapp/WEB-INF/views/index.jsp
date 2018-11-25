<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Tweeter 2.0</title>
    <style>
        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>${title}</h1>

<%-- ===== LOGGED USER ===== --%>

<c:if test="${loggedUser != null}">
    <%-- ===== LOGGED USER INFO ===== --%>
    <div>
        <p>Zalogowany użytkownik: ${loggedUser.login} </p>
        <button><a href="/logout">WYLOGUJ</a></button>
    </div>

    <%-- ===== NEW TWEET FORM ===== --%>
    <div>
        <form:form modelAttribute="addTweet" method="post">
            <div><form:errors path="*" /></div>
            <label for="tweet">Stwórz nowego tweeta</label>
            <form:textarea path="text" name="tweet"/>
            <form:button value="WYŚLIJ"> WYŚLIJ </form:button>
        </form:form>
    </div>

    <%-- ===== TWEETS LIST ===== --%>
    <table>
        <thead>
        <tr>
            <th>Tweet</th>
            <th>Data utworzenia</th>
            <th>Użytkownik</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allTweets}" var="tweet">
            <tr>
                <td>${tweet.text}</td>
                <td>${tweet.created}</td>
                <td>${tweet.user.login}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<%-- ===== NONE LOGGED USER ===== --%>

<c:if test="${loggedUser == null}">
    <div><a href="/registration">rejestracja</a></div>
    <div><a href="/login">logowanie</a></div>
</c:if>

</body>
</html>
