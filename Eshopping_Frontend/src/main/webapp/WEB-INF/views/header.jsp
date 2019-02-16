<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>		
<c:if test="${not empty message}">	
	<div class="alert alert-success">
	${message}
	</div>
	</c:if>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${contextRoot}/">E-site</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${contextRoot}/">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Shop By Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach items="${categoriesList}" var="catObj">
          <li><a href="#">${catObj.categoryName}</a></li>
          </c:forEach>
        </ul>
      </li>
      <li><a href="Contact">Contact Us</a></li>
   
   <!--    <sec:authorize access="hasRole('Role_Admin')"> -->
   <!--   </sec:authorize>-->
     <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin Options
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${contextRoot}/getCategoryForm">Add Category</a></li>
          <li><a href="${contextRoot}/getAllCategories">View All Categories</a></li>
          <li><a href="${contextRoot}/getProductForm">Add Product</a></li>
           <li><a href="${contextRoot}/getAllProducts">View All Products</a></li>
           <li><a href="${contextRoot}/getSupplierForm">Add Supplier</a></li>
        <li><a href="${contextRoot}/getAllSuppliers">View All Suppliers</a></li>
        
        </ul>
      </li>
    </ul>
    <!-- <c:if test="${not empty sessionScope.userObject}">    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#">Welcome : ${userObject.firstName} ${userObject.lastName}</a></li>
      <li><a href="${contextRoot}/logoutUser"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
    </c:if> -->
    
		 <sec:authorize access="isAuthenticated()">
         	<li  style="color:white">Welcome : ${sessionScope.userObject.firstName} ${sessionScope.userObject.lastName}</li>
         	<li><a href="${contextRoot}/logoutUser">Logout</a></li>
       		<li><a href="${contextRoot}/viewCart"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
       	</sec:authorize>
     
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${contextRoot}/getSignupForm"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${contextRoot}/getLoginForm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    
  </div>
</nav>