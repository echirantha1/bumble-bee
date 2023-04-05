<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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

	<div class="row align-items-center justify-content-center mt-5">
		<div class="col-md-9 mx-auto text-center">
			<p class="text-success">${message}</p>
		</div>
	</div>
      
 	<div class="card col-md-10 mx-auto mt-4">
		<form method="post" action="manage-customer" class="row align-items-center justify-content-center mt-3">	
		 <h5 class="card-title text-center mb-5 fw-light fs-5">Sign Up</h5>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtNic">National Identity Card</label>
					<input type="text" id="txtNic" class="form-control" name="nic" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtName">Full Name</label>
					<input type="text" id="txtName" class="form-control" name="name" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtEmail">E-mail</label>
					<input type="text" id="txtEmail" class="form-control" name="email" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtPassword">Password</label>
					<input type="text" id="txtPassword" class="form-control" name="password" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtAddress">Address</label>
					<input type="text" id="txtAddress" class="form-control" name="address" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtMobile">Mobile</label>
					<input type="text" id="txtMobile" class="form-control" name="mobile" />
				</div>
			</div>
			
			<input type="hidden" name="type" value="register" />
			
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-2">
            		<button type="submit" id="btnsubmit" class="btn btn-success form-control">Register</button>
            	</div>
            </div>
            <div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-2 text-center">
            		<a href="auth-customer.jsp" class="text-decoration-none">Sign in</a>
            	</div>
            </div>
		</form>
	</div>

</body>
</html>