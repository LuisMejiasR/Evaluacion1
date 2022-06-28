<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 20-06-2022
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>REGISTRO</title>
    <!-- agregamos el link para que funcione bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
</head>
<body>
<h1>Hola, por favor edita tu mochila:</h1>
<div>
    <c:if test="${msgError!= null }">
        <c:out value="${msgError}"></c:out>
    </c:if>

    <%--@elvariable id="mochila" type="java"--%>
    <form:form action="/registro/actualizar/${mochila.id}" method="post" modelAttribute="mochila">
    <form:label path="color" class="form-label">Color: </form:label>
    <form:input path="color" class="form-control"/>
    <br>
    <form:label path="modelo" class="form-label">Modelo: </form:label>
    <form:input path="modelo" class="form-control"/>
    <br> <!-- saldo de linea -->
    <form:label path="capacidad" class="form-label">Capacidad en kg.: </form:label>
    <form:input type="number" path="capacidad" class="form-control"/>
    <br>
    <!-- submit para el envío de información -->
    <button type="submit" class="btn btn-primary">Editar Mochila</button>
        </form:form>
</div>

</body>
</html>
