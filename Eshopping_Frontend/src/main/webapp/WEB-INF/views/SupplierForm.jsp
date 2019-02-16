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
	<!-- header -->
	<jsp:include page="header.jsp"/>
	
	<!-- body -->
	<div class="container">
		<h1>${formLabel}</h1>
<f:form action="${contextRoot}/submitSupplier" method="post" modelAttribute="key1">

	<c:if test="${not empty op}">
<div class="form-group">
      <label for="supplierId">Supplier Id:</label>
      <f:input type="text" path="supplierId"  class="form-control" id="supplierId" placeholder="Enter Supplier Id" name="supplierId" readonly="true"/>
    </div>
    </c:if>
    
    <div class="form-group">
      <label for="suppName">Supplier Name:</label>
      <f:input type="text" path="suppName"  class="form-control" id="suppName" placeholder="Enter Supplier Name" name="suppName"/>
    <f:errors path="suppName"/>
    </div>
    <div class="form-group">
      <label for="suppMobile">Supplier Mobile:</label>
      <f:input type="text" path="suppMobile" class="form-control" id="suppMobile" name="desc" placeholder="Enter Supplier Mobile"/>
   <f:errors path="suppMobile"/>
    </div>
    <div class="form-group">
      <label for="address">Supplier Address:</label>
      <f:input type="text" path="address" class="form-control" id="address" name="address" placeholder="Enter Supplier Address"/>
    <f:errors path="address"/>
    </div>
    <button type="submit" class="btn btn-default">${btnLabel}</button>
  </f:form>
	</div>
</body>
</html>






