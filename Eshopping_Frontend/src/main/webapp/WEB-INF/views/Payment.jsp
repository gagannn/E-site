<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<style>
</style>
</head>

<body class="bg-light">
	<!-- header -->
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="py-5 text-center">
			<h2>
				<strong>Checkout</strong>
			</h2>
			<!-- <p class="lead">Below is an example form built entirely with Bootstrap's form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>-->
		</div>
		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Your cart</span> <span
						class="badge badge-secondary badge-pill">${items}</span>
				</h4>
				<ul class="list-group mb-3">
					<c:forEach items="${itemsList}" var="item">
						<li
							class="list-group-item d-flex justify-content-between lh-condensed">
							<div class="col-sm-6">
								<h6 class="my-0">
									<strong>${item.product.productName}</strong>
								</h6>
								<small class="text-muted ">${item.product.description}</small>
							</div> <span class="text-muted text-center col-sm-3"><i
								class="fa fa-close"></i> ${item.quantity}</span> <span
							class="text-muted col-sm-4"><i class="fa fa-inr"></i>${item.product.price*item.quantity}</span>
						</li>
					</c:forEach>
					<li class="list-group-item d-flex justify-content-between"><span>Total
							(INR)</span> <strong><i class="fa fa-inr"></i> ${TotalPrice}</strong></li>
				</ul>
			</div>
			<div class="col-md-8 order-md-1">
				<hr class="mb-4">
				<h4 class="mb-3">
					<strong>Payment</strong>
				</h4>
				<div class="d-block my-3">
					<div class="custom-control custom-radio">
						<input id="credit" name="paymentMethod" type="radio"
							class="custom-control-input" checked required> <label
							class="custom-control-label" for="credit">Credit card</label>
					</div>
					<div class="custom-control custom-radio">
						<input id="debit" name="paymentMethod" type="radio"
							class="custom-control-input" required> <label
							class="custom-control-label" for="debit">Debit card</label>
					</div>
					<div class="custom-control custom-radio">
						<input id="paypal" name="paymentMethod" type="radio"
							class="custom-control-input" required> <label
							class="custom-control-label" for="paypal">Paypal</label>
					</div>
				</div>
				<f:form action="${contextRoot}/addToCart/payment/placeOrder"
					method="post" modelAttribute="key1">
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="nameOnCard">Name on card</label>
							<f:input type="text" placeholder="Enter Name as on Card"
								id="nameOnCard" path="nameOnCard" class="form-control" />
							<f:errors path="nameOnCard" style="color:red;" />
							<!-- 	<small class="text-muted">Full name as displayed on card</small>
						<div class="invalid-feedback">Name on card is required</div>-->
						</div>
						<div class="col-md-6 mb-3">
							<label for="cardNo">Credit card number</label>
							<f:input type="text" path="cardNo" class="form-control"
								id="cardNo" placeholder="Enter 16-digit Card No" />
							<f:errors path="cardNo" style="color:red;" />
							<!-- <div class="invalid-feedback">Credit card number is required
						</div> -->
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="expiry">Expiration</label>
							<f:input type="text" path="expiry" class="form-control"
								id="expiry" placeholder="Enter Expiry" />
							<f:errors path="expiry" style="color:red;" />
							<!-- <div class="invalid-feedback">Expiration date required</div> -->
						</div>
						<div class="col-md-3 mb-3">
							<label for="cc-expiration">CVV</label>
							<f:input type="text" path="cvv" class="form-control" id="cc-cvv"
								placeholder="Enter 3-digit CVV" />
							<f:errors path="cvv" style="color:red;" />
							<!-- <div class="invalid-feedback">Security code required</div>-->
						</div>
					</div>
					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Pay
						Now</button>
				</f:form>
			</div>
		</div>
		<footer class="my-5 pt-5 text-muted text-center text-small">
		</footer>
	</div>
	<jsp:include page="Footer.jsp" />
</body>

</html>
