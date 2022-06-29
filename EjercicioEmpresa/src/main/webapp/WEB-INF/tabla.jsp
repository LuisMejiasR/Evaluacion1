<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 28-06-2022
  Time: 20:14
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
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Edad</th>
            <th scope="col">Acciones</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="usuario" items="${usuariosCapturados}">
            <tr>
                <th scope="row">${usuario.id}</th>
                <td>${usuario.nombre}</td>
                <td>${usuario.apellido}</td>
                <td>${usuario.edad}</td>
                <td><a class="btn btn-warning" href="editar/${usuario.id}" role="button">Editar</a></td>
                <td><a class="btn btn-danger" href="eliminar/${usuario.id}" role="button">Eliminar</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <td><a class="btn btn-primary" href="/usuario" role="button">Agregar nuevo usuario</a></td>
</div>

</body>
</html>
