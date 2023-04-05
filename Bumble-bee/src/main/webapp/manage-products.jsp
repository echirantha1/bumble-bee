<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Bumble Bee</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	    
	<jsp:include page="nav-bars.jsp"></jsp:include>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
      
    <div class="container mt-4">
		<nav class="nav nav-pills flex-column flex-sm-row">
		  <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="#">All Products</a>
		  <a class="flex-sm-fill text-sm-center nav-link border" href="add-product.jsp">Add Product</a>
		  <a class="flex-sm-fill text-sm-center nav-link border" href="update-product.jsp">Update Product</a>
		</nav>
	</div>
	
	<div class="row align-items-center justify-content-center mt-5">
		<div class="col-md-9 mx-auto text-center">
			<p class="text-success">${message}</p>
		</div>
	</div>
      
 	<div class="card col-md-10 mx-auto mt-4">
		<table class="table table-striped table-hover">
			  <thead>
			    <tr>
			      <th scope="col"></th>
			      <th scope="col">Product ID</th>
			      <th scope="col">Product Name</th>
			      <th scope="col">Category ID</th>
			      <th scope="col">Brand ID</th>
			      <th scope="col">Quantity</th>
			      <th scope="col">Product Price</th>
			      <th scope="col">Description</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<tag:forEach var="product" items="${productList}">
			  		<tr>
				      <td></td>
				      <td>${product.productId}</td>
				      <td>${product.productName}</td>
				      <td>${product.categoryId}</td>
				      <td>${product.brandId}</td>
				      <td>${product.quantity}</td>
				      <td>${product.productPrice}</td>
				      <td>${product.description}</td>
				      <td>
					      <form method="post" action="manage-products">
					      	<input type="hidden" name="productId" value="${product.productId}" />
					      	<input type="hidden" name="type" value="delete" />
					      	<button type="submit" style="border: none; background-color: transparent;"><i class="fa fa-trash text-danger" aria-hidden="true"></i></button>
					      </form>
				      </td>
				    </tr>
			  	</tag:forEach>
			  </tbody>
			</table>
		</div>
	
    </main>

<script src="/docs/5.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
 
</body>
</html>