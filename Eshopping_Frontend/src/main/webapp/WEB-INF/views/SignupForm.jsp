<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-shopping</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	color: #fff;
	font-family: 'Roboto', sans-serif;
}

.background-image {
	background:
		url(https://images.thrillophilia.com/image/upload/s--m2hvhyRw--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/049/572/original/Camping.jpg.jpg?1458181888);
	height: 100vh;
	margin-top: -30px;
	padding-top: 100px !important;
}

.form-control {
	height: 41px;
	background: #f2f2f2;
	box-shadow: none !important;
	border: none;
}

.form-control:focus {
	background: #e2e2e2;
}

.form-control, .btn {
	border-radius: 3px;
}

.signup-form {
	width: 390px;
	margin: 30px auto;
}

.signup-form form {
	/*color: #999;*/
	border-radius: 3px;
	margin-bottom: 15px;
	background: #fff;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form h2 {
	color: #333;
	font-weight: bold;
	margin-top: 0;
}

.signup-form hr {
	margin: 0 -30px 20px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form input[type="checkbox"] {
	margin-top: 3px;
}

.signup-form .row div:first-child {
	padding-right: 10px;
}

.signup-form .row div:last-child {
	padding-left: 10px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	background: #3598dc;
	border: none;
	min-width: 140px;
}

.signup-form .btn:hover, .signup-form .btn:focus {
	background: #2389cd !important;
	outline: none;
}

.signup-form a {
	color: #fff;
	text-decoration: underline;
}

.signup-form a:hover {
	text-decoration: none;
}

.signup-form form a {
	color: #3598dc;
	text-decoration: none;
}

.signup-form form a:hover {
	text-decoration: underline;
}

.signup-form .hint-text {
	padding-bottom: 15px;
	text-align: center;
	font-size: 15px;
}

.signup-form {
	opacity: 0.8;
	margin-right: 35px;
}
</style>
</head>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty message}">
	<div class="alert alert-danger">${message}</div>
</c:if>

<body>
	<!-- header -->
	<jsp:include page="header.jsp" />
	<div class="background-image">
		<div class="signup-form">
			<f:form action="${contextRoot}/signupUser" modelAttribute="key1"
				method="post" enctype="multipart/form-data">
				<h2>${formLabel}</h2>
				<p>Please fill in this form to create an account!</p>
				<hr>
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<f:input type="text" path="firstName" class="form-control"
								id="firstName" name="firstName" placeholder="First Name" />
							<f:errors path="firstName" style="color:red;" />
						</div>
						<div class="col-xs-6">
							<f:input type="text" path="lastName" class="form-control"
								id="lastName" name="lastName" placeholder="Last Name" />
							<f:errors path="lastName" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<f:input type="email" path="email" class="form-control" id="email"
						placeholder="Email" name="email" />
					<f:errors path="email" style="color:red;" />
				</div>
				<div class="form-group">
					<f:input type="password" path="password" class="form-control"
						id="password" placeholder="Enter Password" name="password" />
					<f:errors path="password" style="color:red;" />
				</div>
				<div class="form-group">
					<f:input type="password2" path="password2" class="form-control"
						id="password2" placeholder="Confirm Password" name="password2" />
					<f:errors path="password2" style="color:red;" />
				</div>
				<div class="form-group">
					<f:input type="mobileNo" path="mobileNo" class="form-control"
						id="mobileNo" placeholder="Enter Mobile No" name="mobileNo" />
					<f:errors path="mobileNo" style="color:red;" />
				</div>
				<!-- <div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
		</div> -->
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg">Sign
						Up</button>
				</div>
			</f:form>
			<div class="hint-text">
				<span style="color: white">Already have an account?</span> <a
					href="${contextRoot}/login">Login here</a>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp" />
</body>

</html>






















