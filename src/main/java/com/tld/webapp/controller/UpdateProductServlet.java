package com.tld.webapp.controller;

import com.tld.webapp.dao.ProductDAO;
import com.tld.webapp.dao.ProductDAOImpl;
import com.tld.webapp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.IIOException;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet (name = "UpdateProductServlet",urlPatterns = "/update-product")
public class UpdateProductServlet extends HttpServlet {
    private final ProductDAO productDAO;

    public UpdateProductServlet() {
        this.productDAO = new ProductDAOImpl();
    }

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vue/updateProduct.jsp").forward(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            String productName = request.getParameter("productName");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
            boolean isAvailable = Boolean.parseBoolean(request.getParameter("isAvailable"));

            Product product = new Product();
            product.setId(productId);
            product.setProductName(productName);
            product.setDescription(description);
            product.setPrice(price);
            product.setStockQuantity(stockQuantity);
            product.setAvailable(isAvailable);

            productDAO.updateProduct(productId ,productName ,description , price, stockQuantity, isAvailable);

            request.setAttribute("successMessage", "Product updated successfully!");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Failed to update the product. Please try again.");
        }

        request.getRequestDispatcher("/vue/updateProduct.jsp").forward(request, response);
    }
}
