<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<jsp:include page="header.jsp" />
<div class="container">
	<br /> <img style="margin-left: -45px !important;"
		src="${pageContext.request.contextPath}/resources/images/OrderPlaced.png"
		style="margin-left: 155px;">
	<p>
		<a href="${contextRoot}/" style="text-decoration: none !important;">
			<button type="button" class="btn btn-primary btn-lg  my"
				style="margin: auto; display: block; margin-bottom: 50px;">
				Continue Shopping <span class="glyphicon glyphicon-arrow-right"></span>
			</button>
		</a>
	</p>
</div>
<jsp:include page="Footer.jsp" />