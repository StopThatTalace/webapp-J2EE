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
import java.time.LocalDate;

@WebServlet(name = "CreateProductServlet", urlPatterns = "/create-product")
public class CreateProductServlet extends HttpServlet {

    private final ProductDAO productDAO;

    public CreateProductServlet() {
        this.productDAO = new ProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vue/createProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String productName = request.getParameter("productName");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
            boolean isAvailable = Boolean.parseBoolean(request.getParameter("isAvailable"));

            // Assuming creationDate is set automatically in the addProduct method
            String creationDate = LocalDate.now().toString();

            Product product = new Product();
            product.setProductName(productName);
            product.setDescription(description);
            product.setPrice(price);
            product.setStockQuantity(stockQuantity);
            product.setAvailable(isAvailable);
            product.setCreationDate(creationDate);

            // Save the product using the DAO
            productDAO.addProduct(product);

            request.setAttribute("successMessage", "Product added successfully!");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Failed to add the product. Please try again.");
        }

        request.getRequestDispatcher("/vue/createProduct.jsp").forward(request, response);
    }
}
