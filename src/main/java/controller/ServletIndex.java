package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/index")
public class ServletIndex extends HttpServlet {
    public void init(){
        System.out.println("Index servlet has begun...");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            //request.getRequestDispatcher("index.jsp").forward(request, response);
            //request.getRequestDispatcher("index.jsp");
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
