<%--
  Created by IntelliJ IDEA.
  User: luism
  Date: 28-06-2022
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>REGISTRO USUARIO</title>
    <!-- agregamos el link para que funcione bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
</head>
<body>
<h1>Hola, por favor registrate:</h1>
<div>
    <c:if test="${msgError!= null }">
        <c:out value="${msgError}"></c:out>
    </c:if>


    <%--@elvariable id="usuario" type="java"--%>
    <form:form action="/usuario/guardar" method="post" modelAttribute="usuario">
        <form:label path="nombre" class="form-label">Nombre: </form:label>
        <form:input path="nombre" class="form-control"/>
        <br>
        <form:label path="apellido" class="form-label">Apellido: </form:label>
        <form:input path="apellido" class="form-control"/>
        <br> <!-- saldo de linea -->
        <form:label path="edad" class="form-label">Edad: </form:label>
        <form:input type="number" path="edad" class="form-control"/>
        <br>
        <!-- submit para el envío de información al action-->
        <button type="submit" class="btn btn-primary">Registrar Usuario</button>
    </form:form>
</div>

</body>
</html>

