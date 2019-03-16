<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set value="${pageContext.request.contextPath}" var="contextRoot"
	scope="session" />


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
.image-size {
	height: 500px !important;
}

.bd-example {
	margin-top: -20px;
}

.main-container {
	width: 73%;
	margin: 50px auto;
	background-color: white;
	position: relative;
	top: -70px;
}
/* .main-container:hover {
background-color: whitesmoke !important;
} */


.side-container {
	width: 20%;
	padding-right: 15px;
	padding-left: 15px;
}

.background-side-container {
	width: 20%;
}

.red-color {
	color: #c04f1d;
	font-weight: bold;
}

.content {
	padding-top: 20px;
	padding-bottom: 20px;
}

.content:hover {
	background-color: #ece7e7;
	
}

#links:hover{
text-decoration:none !important;
}

.image-back {
	background:
		url("data:image/jpeg;base64,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") no-repeat;
		background-size:cover;
	height: 100%;
}

body{
background-color:#f7f7f7 !important;
}
.img-fix {
	max-width: 100%;
	height: 30vh;
}

.overlay {
	position: relative;
	font-size:30px;

	top: 50%;
	color: white;
	
	padding: 5px;
}

.overlay-item{
background-color: #c04f1d;
padding:3px 6px;
}

.overlay-para {
	position: relative;
	top: 55%;
	color: white;
	font-weight: bold;
	font-size:12px;
}
/* Classes for carousal and main body ends */
@media ( max-width : 576px) {
	.text {
		font-size: 1.5em;
	}
	.icon {
		font-size: 15px;
		margin-top: 10px;
	}
}

nav ul li a:active, a:visited {
	border-bottom: 2px orange solid;
}

.Carousel-text-h5 {
	background-color: #f4743c;
	line-height: 1.2;
	margin-left: 10px !important;
	margin-bottom: 0.625rem;
	padding: 0 10px;
	font-size: 4.28571em;
	display: inline-block;
	margin-block-start: 0.83em;
	margin-block-end: 0.83em;
	margin-inline-start: 0px;
	margin-inline-end: 0px;
}
.my{
background-color: #213236 !important;
    color: #fff !important;
    padding: 8px 15px !important;
    margin-right: 1px !important;
    align-items: center;
    text-decoration: none !important;
    display: block;
    font-size: 1.42857em;
    border-color:none !important;
    }
    
   .Carousel-text-h5{
   margin-block-end:0rem;
   margin-bottom:15px;
   font-size:40px !important;
   }
</style>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp" />
	<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
	<div class="bd-example">
		<div id="carouselExampleCaptions" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleCaptions" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
				<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="${pageContext.request.contextPath}/resources/images/hero_slide_2_1_1512x.jpg"
						class="d-block w-100 image-size" alt="..." />
					<div class="carousel-caption d-none d-md-block">
						<h5 class="Carousel-text-h5">Bring it on your next adventure</h5>
						  <p> <a href="${contextRoot}/getAllProducts"> <button type="button" class="btn btn-primary btn-lg  my">Shop now <span class="glyphicon glyphicon-arrow-right"></span></button></a></p>

					</div>
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/images/hero_slide_1_1_1512x.jpg"
						class="d-block w-100 image-size" alt="..." />
					<div class="carousel-caption d-none d-md-block">
						<h5 class="Carousel-text-h5">Take it outdoors</h5>
						<p> <a href="${contextRoot}/getAllProducts"> <button type="button" class="btn btn-primary btn-lg  my">Shop now <span class="glyphicon glyphicon-arrow-right"></span></button></a></p>
					</div>
				</div>
				<div class="carousel-item">
					<img
						src="http://www.mariasfarmcountrykitchen.com/wp-content/uploads/2014/07/camping.jpg"
						class="d-block w-100 image-size" alt="..." />
					<div class="carousel-caption d-none d-md-block">
						<h5 class="Carousel-text-h5">Leave the road, take the trails!</h5>
						<p> <a href="google.com"> <button type="button" class="btn btn-primary btn-lg  my">Shop now <span class="glyphicon glyphicon-arrow-right"></span></button></a></p>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleCaptions"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!-- Carousal ends-->

	<!--Main body starts-->
	<div class="main-container ">
		<div class="row">
			<c:forEach items="${threeRandomProducts}" var="catObj">
			
				<div class="col-md-4 text-center content">
				<a href="${contextRoot}/getProductsByCategory/${catObj.key.categoryId}" id="links">
					<h2 style="font-size: 30px;">${catObj.key.categoryName}</h2>
					<p class="red-color">View All</p>
					<img 
						src="${pageContext.request.contextPath}/resources/images/${catObj.value.imgname1}"
						alt="" class="img-fluid" />
						</a>
				</div>
				
				
			</c:forEach>			
			
		</div>
	</div>
	
		<c:forEach items="${categoriesList}" var="catObj">
			<div class="main-container ">
		<div class="row">
			<div class="background-side-container  ">
			<a href="${contextRoot}/getProductsByCategory/${catObj.categoryId}" id="links">
				<div class="image-back">
				<%-- <a href="${contextRoot}/getProductsByCategory/${catObj.categoryId}" id="links"> --%>
					<h2 class="overlay"><span class="overlay-item">${catObj.categoryName}</span></h2>
					<p class="overlay-para ml-3">View All</p>
					
				</div>
				</a>
			</div>
			
			<c:forEach items="${fourProducts}" var="prodObj">
			<c:if test="${catObj.categoryId eq prodObj.categoryId}">
			<div class="side-container content text-center">
			 <a href="${contextRoot}/product/${prodObj.productId}" id="links">  
				<img
					src="${pageContext.request.contextPath}/resources/images/${prodObj.imgname1}"
					alt="" class="img-fix" />
					<p>${prodObj.productName}</p>
					<p>${prodObj.price}</p>
					<sec:authorize access="hasAuthority('Role_User')">
									<a href="${contextRoot}/addToCart/${prodObj.productId}"><i class="fa fa-shopping-cart icon"></i>
									</a>
										</sec:authorize>
									<sec:authorize access="isAnonymous()">
									<a href="${contextRoot}/addToCart/${prodObj.productId}"><i class="fa fa-shopping-cart icon"></i>
									</a>
									</sec:authorize>
			</a>		
			</div>
			</c:if>
			
			</c:forEach>
			
			</div>
	</div>
		</c:forEach>	
		
	<!-- Main body ends-->
	<!-- Script tags starts-->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.smartmenus/1.1.0/jquery.smartmenus.min.js"
		integrity="sha256-L+Zo9Q4bGfdY06BqwMYLDoacazH6GrQxkLavPdT0a44="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.smartmenus/1.1.0/addons/bootstrap-4/jquery.smartmenus.bootstrap-4.min.js"
		integrity="sha256-86IE6BxjIc6DQWhu21kSaAYt4+62VrnCr+JkpdajhAY="
		crossorigin="anonymous"></script>
	<!--Script tags ends-->
	<jsp:include page="Footer.jsp" />
</body>
</html>



