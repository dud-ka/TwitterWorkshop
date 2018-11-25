<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kd
  Date: 25.11.18
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Website</title>
    <style>
        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<button><a href="/">Powrót na strone główną</a></button>
<%-- ===== NEW TWEET FORM ===== --%>
<div>
    <form:form modelAttribute="addTweetOnUserPage" method="post">
        <div><form:errors path="text" /></div>
        <label for="tweet">Stwórz nowego tweeta</label>
        <form:input path="text" name="tweet"/>
        <form:button value="WYŚLIJ"> WYŚLIJ </form:button>
    </form:form>
</div>

<%-- ===== TWEETS LIST ===== --%>
<table>
    <thead>
    <tr>
        <th>Tweet</th>
        <th>Data utworzenia</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allTweets}" var="tweet">
        <tr>
            <td>${tweet.text}</td>
            <td>${tweet.created}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
