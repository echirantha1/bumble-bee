<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
<div class="login">

<h1>Welcome to Admin Login</h1>
<form action=LoginServlet method=post>
	<div class="fields">
		<p class="fieldtext">Username </p>
		<input type="text" id="username" class="inputfield">
	</div>
	
	<div class="fields">
		<p class="fieldtext">Password<p>
		<input type="password" id="password" class="inputfield">
	
<input type=submit value=Login>
<input type=reset>
<f/from>
</body>
</html>