<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Project with J2EE & JSP</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
  <header>
    <h1>Here's some request you can make with my bdd</h1>
    <button>
      <a class="connect" href="${pageContext.request.contextPath}/auth">Connect</a>
    </button>
  </header>
<br/>
<section>
  <a href="${pageContext.request.contextPath}/create-product">Create a product 🚲</a>
  <a href="${pageContext.request.contextPath}/get-all-products">Retrieve a list of products 📃</a>
  <a href="${pageContext.request.contextPath}/product-servlet">Retrieve an example of a product 🤖</a>
  <a href="${pageContext.request.contextPath}/update-product">Update a product 🧬</a>
  <a href="${pageContext.request.contextPath}/delete-product">Delete a product by ID 🚮</a>
  <a href="${pageContext.request.contextPath}/keyword">Select a product by Keyword 🤠</a>
</section>
<form action="${pageContext.request.contextPath}/get-by-id?" method="get">
  <label for="id">Retrieve product by ID 🆔</label>
  <input type="number" id="id" name="id" required>
  <button class="GetById" type="submit">Go</button>
</form>
</body>
</html>
