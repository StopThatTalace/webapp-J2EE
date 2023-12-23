<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 22/12/2023
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<h2>Product Details</h2>

<%-- Retrieve the product attribute from the request --%>
<%
    com.tld.webapp.model.Product product = (com.tld.webapp.model.Product)request.getAttribute("product");
%>

<%-- Display product details --%>
<p>ID: <%= product.getId() %></p>
<p>Name: <%= product.getProductName() %></p>
<p>Description: <%= product.getDescription() %></p>
<p>Price: <%= product.getPrice() %></p>
<p>Stock Quantity: <%= product.getStockQuantity() %></p>
<p>Available: <%= product.isAvailable() %></p>
<p>Creation Date: <%= product.getCreationDate() %></p>
</body>
</html>
