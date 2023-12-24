package com.tld.webapp.controller;

import com.tld.webapp.dao.ProductDAO;
import com.tld.webapp.dao.ProductDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", urlPatterns = "/delete-product")
public class DeleteProductServlet extends HttpServlet {

    private final ProductDAO productDAO;

    public DeleteProductServlet() {
        this.productDAO = new ProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vue/deleteProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("product_id"));

            productDAO.deleteProduct(productId);

            request.setAttribute("successMessage", "Product deleted successfully!");  // Updated success message
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Failed to delete the product. Please try again.");  // Updated error message
        }

        request.getRequestDispatcher("/vue/deleteProduct.jsp").forward(request, response);
    }
}
