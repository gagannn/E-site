<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
<c:if test="${not empty message}">	
	<div class="alert alert-danger">
	${message}
	</div>
	</c:if>
	<!-- header -->
	<jsp:include page="header.jsp"/>
	
	<!-- body -->
	<div class="container">
		<h1>${formLabel}</h1>
<f:form action="${contextRoot}/loginUser" method="post" modelAttribute="key1">

    <div class="form-group">
      <label for="email">Email id:</label>
      <f:input type="email" path="email"  class="form-control" id="email" placeholder="Enter Email id" name="email"/>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <f:input type="password" path="password" class="form-control" id="password" name="password" placeholder="Enter password"/>
    </div>
    <button type="submit" class="btn btn-default">${btnLabel}</button>
  </f:form>
	</div>
</body>
</html>






