<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${pageContext.request.contextPath}" var="contextRoot" scope="session"/>


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
	
	<c:forEach items="${productsList}" var="prodObj">

	<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/${prodObj.imgname1}" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">${prodObj.productName}     ${prodObj.price}</h5>
    <p class="card-text">${prodObj.description}</p>
    <a href="${contextRoot}/addToCart/${prodObj.productId}" class="btn btn-primary"> <span class="glyphicon glyphicon-shopping-cart"></span></a>  
  </div>
</div>

 </c:forEach>
 
</body>
</html>