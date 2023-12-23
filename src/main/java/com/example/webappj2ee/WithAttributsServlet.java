package com.example.webappj2ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class WithAttributsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = "Utilisateur";
        Integer age = 20;

        request.setAttribute("nom", nom);
        request.setAttribute("age", age);

        this.getServletContext().getRequestDispatcher("/vue/jspWithAttributs.jsp").forward( request, response );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
