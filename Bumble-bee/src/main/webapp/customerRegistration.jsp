<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.inline-form{
display:inline-block;
}
input{
    height: 40px;
    width: 450px;
    border-style: solid;
    border-color: #dadada;
    border-radius: 10px;
}

input:focus {
    box-shadow: 0px 0px 7px rgb(0 11 180);
    border-color: rgb(0 11 180);
}
 button {
            background-image: linear-gradient(to right, #00c6ff 0%, #0072ff  51%, #00c6ff  100%);
            margin: 10px;
            margin-left: 0px;
            padding: 15px 25px;
            text-align: center;
            text-transform: uppercase;
            transition: 0.5s;
            background-size: 200% auto;
            color: white;            
            box-shadow: 0 0 20px #eee;
            border-radius: 10px;
            display: block;
            width:250px
          }

          button:hover {
            background-position: right center; /* change the direction of the change here */
            color: #fff;
            text-decoration: none;
          }
          
          form{    float: right;
    padding-right: 5%;
}
</style>
<script type="text/javascript">

	function validateemail(){
	var email = document.forms["customerRegistration"]["email"].value;
	var emailagain = document.forms["customerRegistration"]["emailagain"].value;
	
	if( email!=emailagain)
	
      
        document.getElementById('emailagain').style.border="1px solid red";
        
		return false;
	
	
	function validatepassword(){
	
	var password = document.forms["customerRegistration"]["password"].value;
	var passwordagain = document.forms["customerRegistration"]["passwordagain"].value;
	
	if(password!=passwordagain && email!=emailagain)
	
        document.getElementById('passwordagain').style.border="1px solid red";
        
		return false;
	
	}
	
	}
	
	function validateRegistraion(){
		validatepassword();
		validateemail();
	}
	

</script>
</head>
<body>
  <form name="customerRegistration"action="<%= request.getContextPath() %>/register" method="post" onsubmit="return validateRegistraion()">
<div>

<div>
	<div class="inline-form">
		<p class="fieldtext">First Name</p>
		<input type="text" id="name" name="name">
	</div>
		
</div>
<div>
	<div>
		<div class="inline-form">
		<p class="fieldtext">Email</p>
		<input type="email" id="email" name="email">
	</div>
	<div class="inline-form">
		<p class="fieldtext">Email Again</p>
		<input type="email" id="emailagain" name="emailagain">
	</div>
</div>

<div>
	<div class="inline-form">
		<p class="fieldtext">Password</p>
		<input type="password" id="password" name="password">
	</div>
	<div class="inline-form">
		<p class="fieldtext">Password Again</p>
		<input type="password" id="passwordagain" name="passwordagain">
	</div>
</div>
<div class="inline-form">
		<p class="fieldtext">Address</p>
		<input type="text" id="address" name="address">
	</div>
<div>
	<div class="inline-form">
		<p class="fieldtext">Date of Birth</p>
		<input type="date" id="birthday" name="birthday">
	</div>

	<div class="inline-form">
		<p class="fieldtext">Mobile</p>
		<input type="tel" id="mobile" name="mobile" >
	</div>
</div>

<div>
	<div class="inline-form">
		<p class="fieldtext">NIC</p>
		<input type="text" id="nic" name="nic">
	</div>
</div>

<div>
  <input type = "submit" value = "Submit" />
</div>

</div>
</form>
</body>
</html>