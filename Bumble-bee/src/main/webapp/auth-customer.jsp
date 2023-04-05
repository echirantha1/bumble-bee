<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Bumble Bee</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<style type="text/css">
body {
  background: #007bff;
  background: linear-gradient(to right, #0062E6, #33AEFF);
}

.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
}
</style>

</head>
<body>
	<div class="container">
	    <div class="row">
	      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
	        <div class="card border-0 shadow rounded-3 my-5">
	          <div class="card-body p-4 p-sm-5">
	            <h5 class="card-title text-center mb-5 fw-light fs-5">Sign In</h5>
	            <form>
	              <div class="form-floating mb-3">
	                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
	                <label for="floatingInput">Email address</label>
	              </div>
	              <div class="form-floating mb-3">
	                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
	                <label for="floatingPassword">Password</label>
	              </div>
	
	              <div class="d-grid">
	                <button class="btn btn-success btn-login text-uppercase fw-bold" type="submit">Sign in</button>
	              </div>
	              <hr class="my-4">
	              <div class="d-grid">
	                <a class="btn btn-primary btn-login text-uppercase fw-bold" href="auth-register.jsp">Register</a>
	              </div>
	            </form>
	          </div>
	        </div>
	      </div>
	    </div>
  	</div>
</body>
</html>