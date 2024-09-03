package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DecisionLogics;
import templates.MessageTemplate;

import java.io.IOException;

@WebServlet("/dilemma-stage")
public class ServletDilemmaStage extends HttpServlet {

    private DecisionLogics decisionLogics = new DecisionLogics();
    private String stageCounter;
    private String namePlayer;

    public void init() {
        System.out.println("Dilemma stage servlet has begun...");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        boolean choicePlayer = Boolean.parseBoolean(request.getParameter("choice-player"));
        MessageTemplate dilemmaStageTemplate = decisionLogics.workingPlayerChoice(choicePlayer);
        namePlayer = "Temporal";
        stageCounter = Integer.toString(decisionLogics.getStageCounter());
        try {
            request.setAttribute("template", dilemmaStageTemplate);
            request.setAttribute("template2", namePlayer);
            request.setAttribute("template3", stageCounter);
            request.getRequestDispatcher(dilemmaStageTemplate.getTargetJspFile()).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
