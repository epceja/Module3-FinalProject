<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Decidir Alternativa</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>
            <c:out value="${template.title}"/>
        </h1>
        <h1>
            <c:out value="${template.question}"/>
        </h1>
        <form method="POST" action="/final-project/dilemma-stage">

            <fieldset id="opciones-desafio">

              <legend id="legend-opciones">
                <c:out value="${template.legend}"/>
              </legend>

              <div>
                <input type="radio" id="si" name="choice-player" value="true" checked />
                <label for="si">
                    <c:out value="${template.yes}"/>
                </label>
              </div>

              <div>
                <input type="radio" id="no" name="choice-player" value="false" />
                <label for="no">
                    <c:out value="${template.no}"/>
                </label>
              </div>
            </fieldset>
            </br>
            <input type="submit" value="Enviar Respuesta"/>
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