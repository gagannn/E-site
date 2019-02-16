<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-site</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"/>
	
	<!-- body -->
	<div class="container">
	
	<c:if test="${not empty message}">	
	<div class="alert alert-success">
	${message}
	</div>
	</c:if>
	
	
	<table  class="table table-striped">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Description</th>
			<th>Category</th>
			<th>Supplier</th>
			<th>Image</th>
			<th>Update</th>
			<th>Delete</th>
			<th>Add to Cart</th>
		</tr>
		<c:forEach items="${productsList}" var="prodObj">
			<tr>
				<td>${prodObj.productName}</td>
				<td>${prodObj.price}</td>
				<td>${prodObj.quantity}</td>
				<td>${prodObj.description}</td>
				<td>${prodObj.categoryId}</td>
				<td>${prodObj.supplierId}</td>
				<td><img src="${pageContext.request.contextPath}/resources/images/${prodObj.imgname1}"/></td>
				<td>
				<a href="${contextRoot}/editProduct/${prodObj.productId}">
          				<span class="glyphicon glyphicon-edit"></span>
        			</a>
				</td>
				<td>
					
        		<a href="${contextRoot}/deleteProduct/${prodObj.productId}">
          				<span class="glyphicon glyphicon-trash"></span>
        			</a>
				</td>
				<td>
					
        		<a href="${contextRoot}/addToCart/${prodObj.productId}">
          				<span class="glyphicon glyphicon-ok"></span>
        			</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>