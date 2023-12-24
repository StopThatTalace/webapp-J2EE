<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product by keyword</title>
</head>
<body>
<h2>Product by keyword</h2>
<form action="${pageContext.request.contextPath}/keyword" method="post">
    <label for="keyword">Product Name:</label>
    <input type="text" id="keyword" name="keyword" required><br>
    <input type="submit" value="Search">
</form>

<c:if test="${not empty error}">
    <div class="error" style="color: red;">
            ${error}
    </div>
</c:if>

<c:if test="${not empty product}">
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
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.stockQuantity}</td>
            <td>${product.available ? 'Yes' : 'No'}</td>
            <td>${product.creationDate}</td>
        </tr>
    </table>
</c:if>

<c:if test="${empty product}">
    <p>Product not found or an error occurred.</p>
</c:if>
</body>
</html>
