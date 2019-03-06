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
	.container-size{
	width:500px !important;
	margin-bottom:30px;
	box-shadow:5px 5px 5px 5px rgb(187, 193, 204) !important;
	padding-bottom:30px;
	}
	
	body{
	background-color:#f7f7f7 !important;
	}
	
	button{
  margin:auto;
  display:block;
}
	</style>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp" />

	<!-- body -->
	<div class="container container-size">
		<h1 class="text-center">${formLabel}</h1>
		<br>
		<f:form action="${contextRoot}/submitProduct" method="post"
			modelAttribute="key1" enctype="multipart/form-data">

			<c:if test="${not empty op}">
				<div class="form-group">
				<div class="row">
				<div class="col-sm-3 text-center">
				<label for="categoryId">Product Id:</label>
				</div>
				<div class="col-sm-9">
				<f:input type="text" path="productId" class="form-control"
						id="productName" placeholder="Enter Product Id" name="productId"
						readonly="true" />
				</div>
				</div>
					
					

				</div>
			</c:if>

			<div class="form-group">
			<div class="row">
			<div class="col-sm-3 text-center">
			<label for="productName">Product Name:</label>
			</div>
			<div class="col-sm-9">
			
				<f:input type="text" path="productName" class="form-control"
					id="productName" placeholder="Enter Product Name"
					name="productName" />
				<f:errors path="productName" style="color:red;" />
			</div>
			</div>
				
			</div>
			<div class="form-group">
			<div class="row">
			<div class="col-sm-3 text-center">
			<label for="price">Price:</label>
			</div>
			<div class="col-sm-9">
			<f:input type="text" path="price" class="form-control" id="price"
					name="price" placeholder="Enter Product Price" />
				<f:errors path="price" style="color:red;"/>
			</div>
			</div>
				
				
			</div>
			<div class="form-group">
			<div class="row">
			<div class="col-sm-3 text-center">
			<label for="quantity">Quantity:</label>
			</div>
			<div class="col-sm-9">
			<f:input type="text" path="quantity" class="form-control"
					id="quantity" name="quantity" placeholder="Enter Product Quantity" />
				<f:errors path="quantity" style="color:red;" />
			</div>
			</div>
				
				
			</div>
			<div class="form-group">
			<div class="row">
			<div class="col-sm-3 text-center">
			<label for="description">Description:</label>
			</div>
			<div class="col-sm-9">
			<f:input type="text" path="description" class="form-control"
					id="desc" name="desc" placeholder="Enter Product Description" />
			</div>
			</div>
				
				
			</div>




			<div class="form-group" >
			<div class="row">
				<label for="pimage1" class="control-label col-sm-3 text-center"> Upload
					Image1 : <c:if test="${not empty op}">
						<img style="margin-left: 152px;margin-top: 10px;width:217%"
							src="${pageContext.request.contextPath}/resources/images/${key1.imgname1}" />
					</c:if>
				</label>
				<div class="col-sm-9">
				
				<div class="custom-file">
    <f:input type="file" class="custom-file-input" id="pimage1" path="pimage1" multiple="multiple"/>
    <label class="custom-file-label" for="pimage1">Choose file...</label>
    
  </div>
				
				
				
				
					<%-- <f:input type="file" class="form-control" id="pimage1"
						placeholder="Choose Image" path="pimage1" multiple="multiple" /> --%>
					<f:errors path="pimage1" style="color:red;"/>
				</div>
			</div>
			</div>

			<div class="form-group">
			<div class="row">
			<div class="col-sm-3 text-center">
				<label class="control-label" for="sel1">Category
					Type:</label>
					</div>
				<div class="col-sm-9 ">
					<f:select class="form-control" id="select" name="select"
						path="categoryId">
						<f:option value="0">Select One:</f:option>
						<c:forEach items="${catObj}" var="pObj">
							<f:option value="${pObj.categoryId}">${pObj.categoryName}</f:option>
						</c:forEach>
					</f:select>
					<f:errors path="categoryId" style="color:red;"/>
					<br>
				</div>
			</div>
			</div>

			<div class="form-group">
			<div class="row">
			<div class="col-sm-3 text-center">
				<label class="control-label" for="sel1">Supplier:</label>
				</div>
				<div class="col-sm-9 ">
					<f:select class="form-control" id="select" name="select"
						path="supplierId">
						<f:option value="0">Select One:</f:option>
						<c:forEach items="${suppObj}" var="pObj">
							<f:option value="${pObj.supplierId}">${pObj.suppName}</f:option>
						</c:forEach>
					</f:select>
					<f:errors path="supplierId" style="color:red;" />
					<br>
				</div>
			</div>
			</div>
<div class="text-center">
<button type="submit" class="btn btn-info">${btnLabel}</button>
</div>
			
		</f:form>
	</div>
	<jsp:include page="Footer.jsp" />
</body>
</html>






