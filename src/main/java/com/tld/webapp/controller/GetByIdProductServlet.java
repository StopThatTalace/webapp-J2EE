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
import java.util.List;

@WebServlet(name = "GetByIdProductServlet", urlPatterns = "/get-by-id")
public class GetByIdProductServlet extends HttpServlet {
    private final ProductDAO productDAO;

    public GetByIdProductServlet() {
        this.productDAO = new ProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdParam = request.getParameter("id");

        if (productIdParam != null && !productIdParam.isEmpty()) {
            try {
                int productId = Integer.parseInt(productIdParam);

                Product product = productDAO.getProductById(productId);

                if (product != null) {
                    request.setAttribute("product", product);

                    request.getRequestDispatcher("/vue/ProductById.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect(request.getContextPath() + "/vue/error.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
