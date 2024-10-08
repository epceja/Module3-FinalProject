<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Etapa Final y Reiniciar</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <!--
        <h1><%=request.getAttribute("template.title")%></h1>
        <h1><c:out value="${template.title}"/></h1>
        <h1>${template.title}</h1>
        -->
        <h1>
            <c:out value="${template.title}"/>
        </h1>
        <h1>
            <c:out value="${template.question}"/>
        </h1>
        <h2>
            <c:out value="${template.legend}"/>
        </h2>
        <form method="GET" action="/final-project/index">
            <input type="submit" value="Regresar al Inicio"/>
        </form>
        </br></br>
        <fieldset name="datos-juego" id="datos-juego">
            <legend>Datos del Juego</legend>
            <h5>
                <label>Nombre: </label>
                <c:out value="${name}"/>
            </h5>
            <h5>
                <label>Intentos: </label>
                <c:out value="${counter}"/>
            </h5>
        </fieldset>
    </body>
</html>