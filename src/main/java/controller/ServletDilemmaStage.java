package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DecisionLogics;
import templates.MessageTemplate;

import java.io.IOException;

@WebServlet("/dilemma-stage")
public class ServletDilemmaStage extends HttpServlet {

    private DecisionLogics decisionLogics = new DecisionLogics();
    private String playerName;
    private Integer attemptsCounter;

    public void init() {
        System.out.println("Dilemma stage servlet has begun...");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        playerName = (String) session.getAttribute("player-Name");
        //session.setAttribute("player-Name", playerName);  // This only for reference
        request.setAttribute("name", playerName);

        attemptsCounter = (Integer) session.getAttribute("attempts-Counter");
        attemptsCounter++;
        session.setAttribute("attempts-Counter", attemptsCounter);
        request.setAttribute("counter", attemptsCounter);

        boolean choicePlayer = Boolean.parseBoolean(request.getParameter("choice-player"));
        MessageTemplate dilemmaStageTemplate = decisionLogics.workingPlayerChoice(choicePlayer);
        request.setAttribute("template", dilemmaStageTemplate);

        try {
            request.getRequestDispatcher(dilemmaStageTemplate.getTargetJspFile()).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
