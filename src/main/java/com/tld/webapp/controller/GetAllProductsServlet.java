package com.tld.servlet;

import com.tld.webapp.dao.ProductDAO;
import com.tld.webapp.dao.ProductDAOImpl;
import com.tld.webapp.model.Product;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllProductsServlet", urlPatterns = "/get-all-products")
public class GetAllProductsServlet extends HttpServlet {

    private final ProductDAO productDAO;

    public GetAllProductsServlet() {
        this.productDAO = new ProductDAOImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get all products from the database
        List<Product> products = productDAO.getAllProducts();

        // Set the products as an attribute in the request
        request.setAttribute("products", products);

        // Forward the request to a JSP page for display
        this.getServletContext().getRequestDispatcher("/vue/productList.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
