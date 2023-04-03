<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Bumble Bee</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container mt-4">
		<nav class="nav nav-pills flex-column flex-sm-row">
		  <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="#">All Products</a>
		  <a class="flex-sm-fill text-sm-center nav-link" href="#">Add Product </a>
		  <a class="flex-sm-fill text-sm-center nav-link" href="#">Search and Update</a>
		  <a class="flex-sm-fill text-sm-center nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
		</nav>
	</div>

	<div class="card col-md-10 mx-auto mt-4">
		<table class="table table-striped table-hover">
		  <thead>
		    <tr class="bg-warning">
		      <th scope="col"></th>
		      <th scope="col">Product ID</th>
		      <th scope="col">Product Name</th>
		      <th scope="col">Category ID</th>
		      <th scope="col">Brand ID</th>
		      <th scope="col">Quantity</th>
		      <th scope="col">Product Price</th>
		      <th scope="col">Description</th>
		      <th scope="col">Added Date</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<tag:forEach var="product" items="${productList}">
			    <tr>
			      <th scope="row"></th>
			      <td>${product.productId}</td>
			      <td>${product.productName}</td>
			      <td>${product.categoryId}</td>
			      <th>${product.brandId}</th>
			      <td>${product.quantity}</td>
			      <td>${product.productPrice}</td>
			      <td>${product.description}</td>
			      <td>${product.date}</td>
			    </tr>
		    </tag:forEach>
		  </tbody>
		</table>
	</div>


</body>
</html>