<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
.table-border {
	border-right: 1px solid white;
}

td {
	border-right: 1px solid white;
}

body {
	background-color: #f7f7f7 !important;
}
</style>
</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp" />
	<!-- body -->
	<div class="container">
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<table class="table table-striped text-center">
			<tr
				style="background-color: black !important; color: white !important;">
				<th class="table-border text-center">Category Name</th>
				<th class="table-border text-center">Category Description</th>
				<th class="table-border text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${categoriesList}" var="catObj">
				<tr style="background-color: rgba(218, 206, 206, 0.5) !important;">
					<td>${catObj.categoryName}</td>
					<td>${catObj.categoryDescription}</td>
					<td><a href="${contextRoot}/editCategory/${catObj.categoryId}">
							<span class="glyphicon glyphicon-edit"></span>
					</a></td>
					<td><a
						href="${contextRoot}/deleteCategory/${catObj.categoryId}"> <span
							class="glyphicon glyphicon-trash"></span>
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="Footer.jsp" />
</body>

</html>