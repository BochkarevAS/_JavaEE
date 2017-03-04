<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <title>Book</title>
</head>

<body>

    <div style="border: 1px solid black; text-align: right; padding-right: 10px">
        <b>Ник:</b> ${sessionScope.user.nick}
        <b>Логин:</b> ${sessionScope.user.login}
        <a href='/logout'>выход</a>
    </div>

    <div>
        <c:forEach items="${letter}" var="item">
            <a href="/book?letter=item">${item}</a>
        </c:forEach>
    </div>

    <ul id="menu" style="float: left; border: 1px solid black">
        <c:forEach items="${allGenre}" var="genre">
            <li>
                <a href="/book?id=${genre.id}">${genre.name}</a>
            </li>
        </c:forEach>
    </ul>

    <table class="table table-striped">
        <thead>
            <th>Название</th>
            <th>Жанр</th>
            <th>Автор</th>
        </thead>
        <c:forEach items="${allBook}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.genre}</td>
                <td>${book.author}</td>
            </tr>
        </c:forEach>
    </table>

</body>

</html>
