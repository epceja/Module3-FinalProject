package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DecisionLogics;
import templates.MessageTemplate;

import java.io.IOException;

@WebServlet("/final-stage")
public class ServletFinalStage extends HttpServlet {

    private DecisionLogics decisionLogics = new DecisionLogics();

    public void init() {
        System.out.println("Final stage servlet has begun...");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        boolean choicePlayer = Boolean.parseBoolean(request.getParameter("choice-player"));
        MessageTemplate dilemmaStageTemplate = decisionLogics.workingPlayerChoice(choicePlayer);

        try {
            request.setAttribute("template", dilemmaStageTemplate);
            request.getRequestDispatcher(dilemmaStageTemplate.getTargetJspFile()).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
