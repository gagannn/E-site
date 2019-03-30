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
	<br />
	<c:choose>
		<c:when test="${itemsList == 'Not Found'}">
			<!-- <h1>Empty Cart</h1> -->
			<img
				src="${pageContext.request.contextPath}/resources/images/empty_cart_800x600_dribbble.png"
				style="margin-left: 155px;">
			<p>
				<a href="${contextRoot}/">
					<button type="button" class="btn btn-primary btn-lg  my"
						style="margin: auto; display: block; margin-bottom: 50px;">
						Shop now <span class="glyphicon glyphicon-arrow-right"></span>
					</button>
				</a>
			</p>
		</c:when>
		<c:otherwise>
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${itemsList}" var="item">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img
											src="${pageContext.request.contextPath}/resources/images/${item.product.imgname1}"
											alt="..." class="img-responsive" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${item.product.productName}</h4>
										<p>${item.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">${item.product.price}</td>
							<td data-th="Quantity" class="text-center">
								<%-- <input type="number" class="form-control text-center" value="${item.quantity }"> --%>
								<p>
									<a href="${contextRoot}/addToCart/increase/${item.itemId}"
										class="glyphicon glyphicon-chevron-up text-center"
										style="text-decoration: none;"></a>
								</p> ${item.quantity}
								<p>
									<a href="${contextRoot}/addToCart/decrease/${item.itemId}"
										style="color: #c71c1c; text-decoration: none;"
										onMouseOver="this.style.color='red'"
										onMouseOut="this.style.color='#c71c1c'"
										class="glyphicon glyphicon-chevron-down text-center"> </a>
								</p>
							</td>
							<td data-th="Subtotal" class="text-center">${item.product.price*item.quantity}</td>
							<td class="actions" data-th=""><a
								href="${contextRoot}/addToCart/delete/${item.itemId}"
								onMouseOver="this.style.color='red'"
								onMouseOut="this.style.color='#c71c1c'"
								class="glyphicon glyphicon-trash"
								style="color: #c71c1c; text-decoration: none;"></a> <!-- <i class="fa fa-trash-o"> -->
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot style="margin-top: 200px !important;">
					<tr class="visible-xs">
						<td class="text-center"><strong>${TotalPrice}</strong></td>
					</tr>
					<tr>
						<td><a href="${contextRoot}/" class="btn btn-warning"><i
								class="fa fa-angle-left"></i> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								${TotalPrice}</strong></td>
						<td><a href="${contextRoot}/addToCart/addressPage"
							class="btn btn-success btn-block">Checkout <i
								class="fa fa-angle-right"></i></a></td>
					</tr>
				</tfoot>
			</table>
		</c:otherwise>
	</c:choose>
</div>
<jsp:include page="Footer.jsp" />
<style>
.table>tbody>tr>td, .table>tfoot>tr>td {
	vertical-align: middle;
}
@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 8rem;
	}
	table#cart tbody {
		display: block;
		margin-bottom: 10px;
		border-radius: 5px;
	}
	table#cart tfoot {
		height: 100px !important;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
}
