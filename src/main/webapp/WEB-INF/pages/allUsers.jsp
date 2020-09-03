<!--<!DOCTYPE HTML>-->
<!--<html xmlns:th="http://www.thymeleaf.org">-->

<!--<head>-->
<!--    <meta charset="UTF-8"/>-->
<!--    <title>MVC</title>-->
<!--    <style>-->
<!--        table th, table td {-->
<!--            padding: 5px;-->
<!--        }-->
<!--    </style>-->
<!--</head>-->

<!--<body>-->

<!--<table border=1>-->
<!--    <p th:text="${title}"></p>-->
<!--    <tr>-->
<!--        <th>ID</th>-->
<!--        <th>NAME</th>-->
<!--        <th>EMAIL</th>-->
<!--    </tr>-->

<!--    <tr th:each="car : ${cars}">-->

<!--        <td th:utext="${car.getNumber()}">ID</td>-->
<!--        <td th:utext="${car.getMark()}">NAME</td>-->
<!--        <td th:utext="${car.getModel()}">EMAIL</td>-->

<!--    </tr>-->

<!--</table>-->

<!--</body>-->
<!--</html>-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD</title>
</head>
<body>
    Hello World!
    ${user}
</body>
</html>