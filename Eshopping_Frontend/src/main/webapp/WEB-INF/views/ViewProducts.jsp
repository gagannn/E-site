
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

<style>
.card-img-top {
	height: 220px;
}

.card {
	margin-bottom: 25px;
	width: auto !important;
}
#links:hover{
text-decoration:none !important;
}
</style>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp" />

	<!-- body -->
	<div class="container">
		<c:if test="${not empty CatName}">
		<h1>${CatName}</h1>
		
		</c:if>
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<div class="container">
			<div class="row">
				<c:forEach items="${productsList}" var="prodObj">
					<div class="col-md-3">
					
						<div class="card" style="width: 18rem;">
						 <a href="${contextRoot}/product/${prodObj.productId}" id="links">
							<img
								src="${pageContext.request.contextPath}/resources/images/${prodObj.imgname1}"
								class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title text-center">${prodObj.productName}</h5>
								<p class="card-text text-right">${prodObj.price}</p>
								<div class="text-right">
								<sec:authorize access="hasAuthority('Role_Admin')">
									<a href="${contextRoot}/editProduct/${prodObj.productId}">
										<span class="glyphicon glyphicon-edit"></span>
									</a> <a href="${contextRoot}/deleteProduct/${prodObj.productId}" style="color:#c71c1c;text-decoration:none;" 
								 onMouseOver="this.style.color='red'"
								onMouseOut="this.style.color='#c71c1c'">
										<span class="glyphicon glyphicon-trash"></span>
								
									</a>
									</sec:authorize> 
									<sec:authorize access="hasAuthority('Role_User')">
									<a href="${contextRoot}/addToCart/${prodObj.productId}"><i class="fa fa-shopping-cart icon"></i>
									<!-- <span
										class="glyphicon glyphicon-ok"></span>  --></a>
										</sec:authorize>
									<sec:authorize access="isAnonymous()">
									<a href="${contextRoot}/addToCart/${prodObj.productId}"><i class="fa fa-shopping-cart icon"></i>
									<!-- <span
										class="glyphicon glyphicon-ok"></span>  --></a>
									</sec:authorize>
									
								</div>
							</div>
							 </a>
						</div>
						
					</div>
				</c:forEach>
			</div>
		</div>
</div>


		



<jsp:include page="Footer.jsp" />
	
</body>
</html>