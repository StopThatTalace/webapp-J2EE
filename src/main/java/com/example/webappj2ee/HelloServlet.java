package com.example.webappj2ee;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(name = "served", value = "/served")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String contextPath = request.getContextPath();

        response.getWriter().write("Served at: " + contextPath);
    }

    public void destroy() {
    }
}
