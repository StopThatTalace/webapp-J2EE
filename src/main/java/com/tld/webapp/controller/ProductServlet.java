package com.tld.webapp.controller;

import com.tld.webapp.model.Product;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product-servlet")
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product(1, "Example Product", "Product description", 29.99, 50, true, "2023-01-01");

        request.setAttribute("product", product);

        this.getServletContext().getRequestDispatcher("/vue/productDetails.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
