<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Bumble Bee</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

	<jsp:include page="nav-bars.jsp"></jsp:include>
	
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>

	<div class="container mt-4">
		<nav class="nav nav-pills flex-column flex-sm-row">
		  <a class="flex-sm-fill text-sm-center nav-link border" href="manage-inventory">All Stocks</a>
		  <a class="flex-sm-fill text-sm-center nav-link border" href="add-inventory.jsp">Add Stock</a>
		  <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="#">Update Stock</a>
		</nav>
	</div>
	
	<div class="row align-items-center justify-content-center mt-5">
		<div class="col-md-9 mx-auto text-center">
			<p class="text-success">${message}</p>
		</div>
	</div>
	
	<div class="card col-md-10 mx-auto mt-4">
		<form method="get" action="manage-inventory" class="row align-items-center justify-content-center mt-3">
			<div class="row align-items-center justify-content-center">
            	<div class="col mb-3 col-md-5 text-center">
					<label for="txtInventoryId">Search Stock ID</label>
					<input type="text" id="txtInventoryId" class="form-control" name="inventoryId" required />
				</div>
			</div>
			<div class="row align-items-center justify-content-center">
				<div class="col mb-3 col-md-5 text-center">
					<button type="submit" class="btn btn-info text-white col-md-2" style="min-width:100px">Search</button>
				</div>
			</div>
			<input type="hidden" name="type" class="form-control" value="specific" />
		</form>
	</div>
	<div class="card col-md-10 mx-auto mt-2">
		<form method="post" action="manage-inventory" class="row align-items-center justify-content-center mt-3">
			<div class="row align-items-center justify-content-center">
            	<div class="col mb-3 col-md-5">
					<label for="txtProductId">Product ID</label>
					<input type="text" id="txtProductId" class="form-control" name="productId" value="${stock.productId}" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center">
            	<div class="col mb-3 col-md-5">
					<label for="txtAvailableStock">Available Stock</label>
					<input type="text" id="txtAvailableStock" class="form-control" name="availableStock" value="${stock.availableStock}" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center">
            	<div class="col mb-3 col-md-5">
					<label for="txtSoldAmount">Sold Amount</label>
					<input type="text" id="txtSoldAmount" class="form-control" name="soldAmount" value="${stock.soldAmount}" />
				</div>
			</div>
			
			<input type="hidden" name="inventoryId" value="${stock.inventoryId}" />
			
			<input type="hidden" name="type" class="form-control" value="update" />
			
			<div class="row align-items-center justify-content-center">
            	<div class="col mb-3 col-md-2">
            		<button type="submit" class="btn btn-success form-control">Update Stock</button>
            	</div>
            </div>
		</form>
	</div>
	
	</main>

<script src="/docs/5.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
  
</body>
</html>