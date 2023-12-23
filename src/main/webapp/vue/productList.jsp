<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tld.webapp.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/productList.css">
</head>
<body>
<h2>Product List</h2>

<%-- Retrieve the products attribute from the request --%>
<%
    List<com.tld.webapp.model.Product> products = (List<Product>)request.getAttribute("products");
%>

<%-- Display product details --%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Stock Quantity</th>
        <th>Available</th>
        <th>Creation Date</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.stockQuantity}</td>
            <td>${product.available}</td>
            <td>${product.creationDate}</td>
        </tr>
    </c:forEach>
</table>

    <div class="link-container">
        <a href="/webapp">Return</a>
    </div>
</body>
</html>
