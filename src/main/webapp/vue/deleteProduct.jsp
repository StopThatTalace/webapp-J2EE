<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 24/12/2023
  Time: 09:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
Hello World
<form action="${pageContext.request.contextPath}/delete-product" method="post">
    <label for="product_id">Product id to delete:</label>
    <input type="number" id="product_id" name="product_id" required><br>

    <input type="submit" value="Delete Product">
</form>
</body>
</html>
