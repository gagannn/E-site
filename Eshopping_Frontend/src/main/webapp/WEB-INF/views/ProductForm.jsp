<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.backend.models.Category,com.backend.models.Supplier" %>
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
<body>
	<!-- header -->
	<jsp:include page="header.jsp"/>
	
	<!-- body -->
	<div class="container">
		<h1>${formLabel}</h1>
<f:form action="${contextRoot}/submitProduct" method="post" modelAttribute="key1" enctype="multipart/form-data">

	<c:if test="${not empty op}">
	<div class="form-group">
      <label for="categoryId">Product Id:</label>
      <f:input type="text" path="productId"  class="form-control" id="productName" placeholder="Enter Product Id" name="productId" readonly="true"/>
    
    </div>
    </c:if>
    
    <div class="form-group">
      <label for="productName">Product Name:</label>
      <f:input type="text" path="productName"  class="form-control" id="productName" placeholder="Enter Product Name" name="productName"/>
  	<f:errors path="productName"/>
    </div>
    <div class="form-group">
      <label for="price">Price:</label>
      <f:input type="text" path="price" class="form-control" id="price" name="price" placeholder="Enter Product Price"/>
    <f:errors path="price"/>
    </div>
     <div class="form-group">
      <label for="quantity">Quantity:</label>
      <f:input type="text" path="quantity" class="form-control" id="quantity" name="quantity" placeholder="Enter Product Quantity"/>
    <f:errors path="quantity"/>
    </div> 
    <div class="form-group">
      <label for="description">Description:</label>
      <f:input type="text" path="description" class="form-control" id="desc" name="desc" placeholder="Enter Product Description"/>
    </div>
    
    
    

<div class="form-group">
<label for="pimage1" 
class="control-label col-sm-2"> Upload Image1 :
</label>
<div class="col-sm-10">
<f:input type="file" class="form-control" 
id="pimage1" placeholder="Choose Image"
 path="pimage1"/>
</div>
</div>
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="sel1">Category Type:</label>
      <div class="col-sm-10 ">
      <f:select class="form-control"  id="select" name="select" path="categoryId">
      	<f:option value="0">Select One:</f:option>
        <c:forEach items="${catObj}"  var="pObj">
        <f:option value="${pObj.categoryId}">${pObj.categoryName}</f:option>
        </c:forEach>
      </f:select>
      <f:errors path="categoryId"/>
      <br>
         </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="sel1">Supplier:</label>
      <div class="col-sm-10 ">
      <f:select class="form-control"  id="select" name="select" path="supplierId">
      	<f:option value="0">Select One:</f:option>
        <c:forEach items="${suppObj}"  var="pObj">
        <f:option value="${pObj.supplierId}">${pObj.suppName}</f:option>
        </c:forEach>
      </f:select>
	<f:errors path="supplierId"/>
      <br>
         </div>
    </div>
    
    <button type="submit" class="btn btn-default">${btnLabel}</button>
  </f:form>
	</div>
</body>
</html>






