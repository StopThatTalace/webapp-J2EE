<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Project with J2EE & JSP</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<h1>Here's some request you can make with my bdd</h1>
<br/>
<section>
  <a href="${pageContext.request.contextPath}/create-product">Create a product 🚲</a>
  <a href="${pageContext.request.contextPath}/get-all-products">Retrieve a list of products 📃</a>
  <a href="${pageContext.request.contextPath}/product-servlet">Retrieve an example of a product 🤖</a>
  <a href="${pageContext.request.contextPath}/update-product">Update a product 🧬</a>
  <a href="${pageContext.request.contextPath}/delete-product">Delete a product by ID 🚮</a>
</section>
<form action="${pageContext.request.contextPath}/get-by-id?" method="get">
  <label for="id">Retrieve product by ID 🆔</label>
  <input type="number" id="id" name="id" required>
  <button type="submit">Go</button>
</form>
</body>
</html>
