

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%-- <c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
</c:if> --%>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>E-Shopping</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery.smartmenus/1.1.0/addons/bootstrap-4/jquery.smartmenus.bootstrap-4.min.css"
	integrity="sha256-IbVTniyadRTitKPpYX/0NvZ1dyrr0e1sD4+MR9q4CWM="
	crossorigin="anonymous" />
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous" />
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Lora"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=B612"
	rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
}

.row {
	margin-right: 0px;
}

.background {
	background-color: #213236;
	height: auto;
	color: white;
	padding: 20px 10px;
}

.text {
	font-size: 50px !important;
	font-family: 'Lora', sans-serif;
	font-weight: bold;
}

.nav-link:hover {
	background-color: #213236 !important;
}

.text a {
	text-decoration: none !important;
	color: white !important;
}

.icon {
	margin-top: 20px;
	font-size: 20px;
	margin-left: 30px;
}

.navbar {
	border-top: 1px solid #ffffff4d !important;
	padding-top: 10px !important;
	padding-bottom: 10px !important;
}

.nav li {
	min-width: 100px !important;
}

.dropdown-menu {

	font-size: 20px !important;
}

.navbar-text-custom {
	font-family: 'B612', sans-serif;
	font-weight: 599;
	font-size: 17px;
}

.sticky-top{
position:sticky !important;
}

.user {
	font-size: 20px;
	text-decoration: none;
	color: white !important;
}

.logout {
	text-decoration: none;
	color: rgba(255, 255, 255, .5) !important;
	font-size: 19px;
	font-weight: 500;
}

.logout:hover {
	text-decoration: none !important;
	color: rgba(255, 255, 255, 0.7) !important;
}

nav ul li a:visited {
	border-bottom: 5px orange solid;
}

#lblCartCount {
    font-size: 12px;
    background: #ff0000;
    border-radius:10px;
    color: #fff;
    padding: 3px 5px;
    vertical-align: top;
    position:relative;
    left:-23px;
}

@media ( max-width : 576px) {
	.text {
		font-size: 1.5em;
	}
	.icon {
		font-size: 15px;
		margin-top: 10px;
	}
	.dropdown-item {
		width: auto !important;
	}
}
</style>
</head>
<body>
	<!-- For icons Starts-->
	<div class="container-fluid background" id="header">
		<div class="row">
			<div class="col-md-4 col-sm-5 col-5 text offset-1">
				<a href="${contextRoot}/">boulder</a>
			</div>
			<div class="col-md-4 col-sm-3 col-5 offset-3 py-5  ">
				<!--  <i class="fa fa-search icon"></i>-->
				<sec:authorize access="hasAuthority('Role_User')">

					<a href="${contextRoot}/addToCart/viewCart"
						onMouseOver="this.style.color='blue'"
						onMouseOut="this.style.color='#1c1cc1'"
						style="font-size: 20px; color: #1c1cc1; text-decoration: none;">
						<span class="glyphicon glyphicon-shopping-cart"
						style="font-size: 23px; color: #1c1cc1 !important;"
						onMouseOver="this.style.color='blue'"
						onMouseOut="this.style.color='#1c1cc1'">
						<label id="lblCartCount">${sessionScope.items}</label>
						</span> <!-- <i class="fa fa-shopping-cart icon"></i> -->
					</a>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<span
						style="margin-left: 20px; color: rgba(255, 255, 255, .5) !important; display: inline;">
						<a class="logout" href="${contextRoot}/getSignupForm"><span
							class="glyphicon glyphicon-user"></span> Sign up</a>
					</span>
					<span
						style="margin-left: 20px; color: rgba(255, 255, 255, .5) !important;">
						<a class="logout" href="${contextRoot}/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a>
					</span>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<span class="user" style="display: inline; margin-left: 30px;">
						Welcome : ${sessionScope.userObject.firstName}
						${sessionScope.userObject.lastName} </span>
					<span
						style="margin-left: 20px; color: rgba(255, 255, 255, .5) !important;">
						<a class="logout" href="${contextRoot}/logoutUser">Logout</a>
					</span>
				</sec:authorize>
			</div>
		</div>
	</div>
	<!-- For icons ends -->

	<!-- Navbar -->
	<nav class="navbar sticky-top navbar-expand-md navbar-dark background ">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<!-- Right nav -->
			<ul class="nav navbar-nav   navbar-text-custom"
				style="margin-left: 6%;">
				<li class="nav-item text-center"><a class="nav-link"
					href="${contextRoot}/">Home</a></li>



				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#">Shop By Category</a>
					<ul class="dropdown-menu" style="width: 100px !important;">

						<c:forEach items="${categoriesList}" var="catObj">

							<li><a class="dropdown-item"
								href="${contextRoot}/getProductsByCategory/${catObj.categoryId}">${catObj.categoryName}</a></li>
						</c:forEach>
					</ul></li>


				<li class="nav-item text-center" id="contactus"><a
					class="nav-link" href="#">Contact us</a></li>

				<sec:authorize access="hasAuthority('Role_Admin')">

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#">Admin Options</a>
						<ul class="dropdown-menu">
							<li class="dropdown"><a
								class="dropdown-item dropdown-toggle" href="#">Category</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item"
										href="${contextRoot}/getCategoryForm">Add Category</a></li>
									<li><a class="dropdown-item"
										href="${contextRoot}/getAllCategories">View All Categories</a></li>
								</ul></li>

							<li class="dropdown"><a
								class="dropdown-item dropdown-toggle" href="#">Product</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item"
										href="${contextRoot}/getProductForm">Add Product</a></li>
									<li><a class="dropdown-item"
										href="${contextRoot}/getAllProducts">View All Products</a></li>
								</ul></li>

							<li class="dropdown"><a
								class="dropdown-item dropdown-toggle" href="#">Supplier</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item"
										href="${contextRoot}/getSupplierForm">Add Supplier</a></li>
									<li><a class="dropdown-item"
										href="${contextRoot}/getAllSuppliers">View All Suppliers</a></li>
								</ul></li>
						</ul></li>
				</sec:authorize>


			</ul>
		</div>
	</nav>
</body>
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

<script>
	$("#contactus").click(function() {
		$('html, body').animate({
			scrollTop : $("#footer").offset().top
		}, 2000);
	});
</script>
<!--Script tags ends-->
</body>
</html>

