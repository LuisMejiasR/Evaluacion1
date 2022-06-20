<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 20-06-2022
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>TABLA DE MOCHILAS</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
</head>
<body>
<div class="container">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Modelo</th>
            <th scope="col">Capacidad en kg.:</th>
            <th scope="col">Color</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="mochila" items="${mochilasCapturadas}">
            <tr>
                <th scope="row">${mochila.id}</th>
                <td>${mochila.modelo}</td>
                <td>${mochila.capacidad}</td>
                <td>${mochila.color}</td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
