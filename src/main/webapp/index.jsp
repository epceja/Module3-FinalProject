<%@ page contentType="text/html; charset=UTF-8"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Proyecto Final Modulo 3</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div id="frame">
            <center>
                <h1>Reto de Memoria</h1>
            </center>
            <h2>Introducción:</h2>
            <p>Este juego está ubicado en el futuro. En el año 3018. </br>
                En un tiempo en que los humanos compartían la tierra con robots
                y los viajes espaciales son rutinarios.
            </p>
            <h2>Conozca al equipo:</h2>
            <p>Mi nombre es John Squirrels, Capitán del Galactic Rush</p>
            <p>Mi nombre es Eleanor Carrey. Me puedes llamar Ellie. Soy la navegante aquí, en el Galactic Rush</p> </br>
            <h3>Si decide continuar con el juego deberá ingresar su nombre</h3>
        </div>

        <form method="GET" action="/final-project/game-begin">
            <label>Escriba su nombre:</label>
            <input type="name" id="jugador-nombre" name="jugador-nombre" required>
            </br>
            <input type="submit" value="Continuar">
        </form>
    </body>
</html>
