package com.tld.webapp.controller;

import com.tld.webapp.dao.ProductDAO;
import com.tld.webapp.dao.ProductDAOImpl;
import com.tld.webapp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "GetByKeywordServlet", urlPatterns = "/keyword")
public class GetByKeywordServlet extends HttpServlet {
    private final ProductDAO productDAO;

    public GetByKeywordServlet() {
        this.productDAO = new ProductDAOImpl();
    }

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vue/ProductByKeyword.jsp").forward(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        if (keyword != null && !keyword.isEmpty()) {
            try {
                Product product = productDAO.getProductByKeyword(keyword);

                if (product != null) {
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("/vue/ProductByKeyword.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "No product found for keyword: " + keyword);
                }

            } catch (Exception e) {
                request.setAttribute("error", "error in the db");
                e.printStackTrace();

            } finally {
                request.getRequestDispatcher("/vue/ProductByKeyword.jsp").forward(request, response);
            }
        }
    }
}
