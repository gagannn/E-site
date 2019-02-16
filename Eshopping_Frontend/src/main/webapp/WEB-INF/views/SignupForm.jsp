<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty message}">	
	<div class="alert alert-danger">
	${message}
	</div>
	</c:if>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"/>
	
	<!-- body -->
	<div class="container">
		<h1>${formLabel}</h1>
<f:form action="${contextRoot}/signupUser" modelAttribute="key1" method="post" enctype="multipart/form-data">


	<div class="form-group">
      <label for="email">Email:</label>
      <f:input type="email" path="email" class="form-control" id="email" placeholder="Enter Email Id" name="email"/>
    <f:errors path="email"/>
    </div>
   
    <div class="form-group">
      <label for="password">Password:</label>
      <f:input type="password"  path="password" class="form-control" id="password" placeholder="Enter Password" name="password"/>
  	<f:errors path="password"/>
    </div>
    
    <div class="form-group">
      <label for="password2">Confirm Password:</label>
      <f:input type="password2"  path="password2" class="form-control" id="password2" placeholder="Enter Password again" name="password2"/>
  	<f:errors path="password2"/>
    </div>
    
    <div class="form-group">
      <label for="firstName">First Name:</label>
      <f:input type="text"  path="firstName" class="form-control" id="firstName" name="firstName" placeholder="Enter First Name"/>
    <f:errors path="firstName"/>
    </div>
     <div class="form-group">
      <label for="lastName">Last Name:</label>
      <f:input type="text"  path="lastName" class="form-control" id="lastName" name="lastName" placeholder="Enter Last Name"/>
    <f:errors path="lastName"/>
    </div> 
    
    <div class="form-group">
      <label for="mobileNo">Mobile No.:</label>
      <f:input type="mobileNo"  path="mobileNo" class="form-control" id="mobileNo" placeholder="Enter Mobile No" name="mobileNo"/>
  	<f:errors path="mobileNo"/>
    </div>
    
    <button type="submit" class="btn btn-default">${btnLabel}</button>
  </f:form>
	</div>
</body>
</html>






