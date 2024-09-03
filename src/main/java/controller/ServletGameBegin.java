package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import templates.MessageTemplate;

import java.io.IOException;

@WebServlet("/game-begin")
public class ServletGameBegin extends HttpServlet {

    private String playerName;
    private Integer attemptsCounter;

    public void init() {
        System.out.println("Game begin servlet has begun...");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        playerName = request.getParameter("jugador-nombre");
        session.setAttribute("player-Name", playerName);
        request.setAttribute("name", playerName);

        attemptsCounter = (Integer) session.getAttribute("attempts-Counter");
        attemptsCounter = 0;
        session.setAttribute("attempts-Counter", attemptsCounter);
        request.setAttribute("counter", attemptsCounter);

        MessageTemplate initialPageTemplate = new MessageTemplate("¡Has perdido la memoria!",
                "¿Aceptas el reto de la Nave?",
                "Elige con cuidado, ¡tu vida está en juego!",
                "Acepto el desafío porque soy muy valiente",
                "No acepto el desafío porque soy miedoso",
                "dilemma-stage.jsp");
        request.setAttribute("template", initialPageTemplate);

        try {
            request.getRequestDispatcher(initialPageTemplate.getTargetJspFile()).forward(request, response);
            //response.sendRedirect(initialPageTemplate.getTargetJspFile()); // This only for reference
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
