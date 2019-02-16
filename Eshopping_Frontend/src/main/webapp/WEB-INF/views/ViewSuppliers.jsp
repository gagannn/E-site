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
			<th>Supplier Name</th>
			<th>Supplier Mobile</th>
			<th>Supplier Address</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${supplierList}" var="suppObj">
			<tr>
				<td>${suppObj.suppName}</td>
				<td>${suppObj.suppMobile}</td>
				<td>${suppObj.address}</td>
				<td>
					<a href="${contextRoot}/editSupplier/${suppObj.supplierId}">
          				<span class="glyphicon glyphicon-edit"></span>
        			</a>
				</td>
				<td>
					
        		<a href="${contextRoot}/deleteSupplier/${suppObj.supplierId}">
          				<span class="glyphicon glyphicon-trash"></span>
        			</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>