<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List,com.backend.models.Category,com.backend.models.Supplier"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
.container-size {
	width: 500px !important;
	margin-bottom: 30px;
	box-shadow: 5px 5px 5px 5px rgb(187, 193, 204) !important;
	padding-bottom: 30px;
}

.address {
	text-decoration: none !important;
	text-transform: uppercase;
	margin-left: 3em;
	font-weight: 600 !important;
}

body {
	background-color: #f7f7f7 !important;
}

button {
	margin: auto;
	display: block;
}
</style>
</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp" />

	<!-- body -->
	<div class="container container-size">
		<!-- <div class="alert alert-warning" id="demo">
	</div> -->
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<h1 class="text-center">Choose Address</h1>
		<br>
		<h4 class="text-center">
			<strong>Choose from saved addresses</strong>
		</h4>
		<br>
		<c:choose>
			<c:when test="${not empty msg}">
				<h6>No addresses found</h6>
			</c:when>
			<c:otherwise>
				<form>
					<c:forEach items="${address}" var="addr">
						<div class="form-group">
							<!-- <label> <input type="radio" name="radio"> -->
							<a href="${contextRoot}/addToCart/payment/${addr.id}"
								class="address">
								${addr.houseNumber},${addr.locality},${addr.city},${addr.state }-${addr.pinCode},${addr.country}
								<a href="${contextRoot}/addToCart/addressForm/${addr.id}"
								style="margin-left: 0.7em"> <span
									class="glyphicon glyphicon-edit"></span>
							</a> <a href="${contextRoot}/addToCart/deleteAddress/${addr.id}"
								style="margin-left: 0.2em"> <span
									class="glyphicon glyphicon-trash"
									style="color: #c71c1c; text-decoration: none;"
									onMouseOver="this.style.color='red'"
									onMouseOut="this.style.color='#c71c1c'"></span>
							</a>
							</a>
							<!-- 	</label> -->
						</div>
					</c:forEach>
				</form>
			</c:otherwise>
		</c:choose>
		<p class="text-center">or</p>
		<h4 class="text-center">
			<strong>Add new address</strong>
		</h4>
		<div class="text-center" style="width: 100%;">
			<a href="${contextRoot}/addToCart/addressForm"><button
					type="button" class="btn btn-info">Add Address</button></a>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-6">
				<br> <a href="${contextRoot}/addToCart/viewCart"
					class="btn btn-warning pull-left" role="button"><i
					class="fa fa-angle-left"></i> Go Back</a>
			</div>
			<div class="col-md-6">
				<br>
				<%-- <a href="${contextRoot}/addToCart/payment" class="btn btn-success pull-right"
					role="button"> Pay <i class="fa fa-angle-right"></i></a> --%>
				<button class="btn btn-success pull-right" onclick="myFunction()">
					Pay <i class="fa fa-angle-right"></i>
				</button>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp" />
	<script>
		function myFunction() {
			alert("Choose an address from saved ones first!!! ");
			/* document.getElementById("demo").innerHTML = "Indicates a warning that might need attention."; */
		}
	</script>
</body>

</html>



















