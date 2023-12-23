<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/createProduct.css">
</head>
<body>
<h2>Create a New Product</h2>

<%-- Check if an error message is available in the request attributes --%>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% if (errorMessage != null) { %>
<div class="error" style="color: red;">
    <%= errorMessage %>
</div>
<% } %>

<%-- Check if a success message is available in the request attributes --%>
<% String successMessage = (String) request.getAttribute("successMessage"); %>
<% if (successMessage != null) { %>
<div class="succes" style="color: green;">
    <%= successMessage %>
</div>
<% } %>

<form action="${pageContext.request.contextPath}/create-product" method="post">
    <label for="productName">Product Name:</label>
    <input type="text" id="productName" name="productName" required><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required><br>

    <label for="stockQuantity">Stock Quantity:</label>
    <input type="number" id="stockQuantity" name="stockQuantity" required><br>

    <label for="isAvailable">Is Available:</label>
    <input type="checkbox" id="isAvailable" name="isAvailable">
    <input type="hidden" name="isAvailable" value="false"><br>

    <input type="submit" value="Create Product">
</form>
</body>
</html>
