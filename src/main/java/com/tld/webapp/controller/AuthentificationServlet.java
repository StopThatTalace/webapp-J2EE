package com.tld.webapp.controller;

import com.tld.webapp.dao.UserDAO;
import com.tld.webapp.dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AuthentificationServlet", urlPatterns = "/auth")
public class AuthentificationServlet extends HttpServlet {

    private final UserDAO userDAO;

    public AuthentificationServlet() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vue/authentification.jsp").forward(request, response);
    }
}
