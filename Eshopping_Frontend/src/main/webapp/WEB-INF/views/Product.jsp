<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-site</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.a {
	margin: 50px 50px 68px 8px;
}

.product-topic {
	margin-top: 90px;
	font-size: 50px;
	margin-left: 20px;
}

.abc {
	font-size: 20px;
}
.btn{
background-color: blue;}
.btn-primary{
background-color: #e8e7e7 !important;
color: black !important;
}
</style>

</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-7">
				<img
					src="${pageContext.request.contextPath}/resources/images/${prodObj.imgname1}"
					class="a" height="542" width="542">
			</div>
			<div class="col-md-5">
				<p class="product-topic">${prodObj.productName} ${prodObj.category.categoryName} </p>
				<div class="abc" style="margin-left: 10px;">
					<p>${prodObj.description}</p>
					<p>${prodObj.price}</p>
					<c:choose>
					<c:when test="${prodObj.quantity > 0}">
					<sec:authorize access="isAnonymous()">
					<a href="${contextRoot}/addToCart/${prodObj.productId}" class="btn btn-primary"
					role="button" style="font-color:black !important;"> Add to Cart <span class="glyphicon glyphicon-shopping-cart"></span></a>
					</sec:authorize>
					<sec:authorize access="hasAuthority('Role_User')">
					<a href="${contextRoot}/addToCart/${prodObj.productId}" class="btn btn-primary"
					role="button" style="font-color:black !important;"> Add to Cart <span class="glyphicon glyphicon-shopping-cart"></span></a>
					</sec:authorize>
					</c:when>
					<c:otherwise>
						<p style="color:red;"> Out of stock</p>
					</c:otherwise>
					</c:choose>
					
					<sec:authorize access="hasAuthority('Role_Admin')">
					<a href="${contextRoot}/editProduct/${prodObj.productId}" class="btn btn-info"
					role="button" style="font-color:black !important;"> Edit <span class="glyphicon glyphicon-edit"></span></a>
					<a href="${contextRoot}/deleteProduct/${prodObj.productId}" class="btn btn-danger"
					role="button" style="font-color:black !important;"> Delete <span class="glyphicon glyphicon-trash"></span></a>
					
					</sec:authorize>
					
				</div>

			</div>


		</div>

	</div>
	<jsp:include page="Footer.jsp" />

</body>
</html>