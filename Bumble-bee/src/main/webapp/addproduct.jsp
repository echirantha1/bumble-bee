<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<label>Product Name</label>
<input type="text" name="productName" id="productname">
<label>Product Product Quantity</label>
<input type="text" name="productQty" id="productQty">
<label>Product Price</label>
<input type="text" name="productPrice" id="productPrice">
<label>Product Catogery</label>
<select name="catogery">
    <c:forEach items="${listCategory}" var="category">
        <option value="${category.id}">${category.name}</option>
    </c:forEach>
</select>
<label>Product Brand</label>
<select name="brand">
    <c:forEach items="${listCategory}" var="category">
        <option value="${category.id}">${category.name}</option>
    </c:forEach>
</select>


</body>
</html>