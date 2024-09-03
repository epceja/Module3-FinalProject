package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DecisionLogics;
import templates.MessageTemplate;

import java.io.IOException;

@WebServlet("/game-begin")
public class ServletGameBegin extends HttpServlet {

    private DecisionLogics decisionLogics = new DecisionLogics();
    private String playerName;
    private Integer stageCounter;

    public void init() {
        System.out.println("Game begin servlet has begun...");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        //MessageTemplate initialPageTemplate = decisionLogics.workingPlayerChoice(true);
        MessageTemplate initialPageTemplate = new MessageTemplate("¡Has perdido la memoria!",
                "¿Aceptas el reto de la Nave?",
                "Elige con cuidado, ¡tu vida está en juego!",
                "Acepto el desafío porque soy muy valiente",
                "No acepto el desafío porque soy miedoso",
                "dilemma-stage.jsp");
        playerName = request.getParameter("jugador-nombre");
        stageCounter = 0;
        try {
            request.setAttribute("template", initialPageTemplate);
            request.setAttribute("template2", playerName);
            request.setAttribute("template3", stageCounter);
            request.getRequestDispatcher(initialPageTemplate.getTargetJspFile()).forward(request, response);
            //response.sendRedirect(initialPageTemplate.getTargetJspFile());
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
