<%@taglib prefix='f' uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>
<title>Login</title>
<meta name="google-signin-client_id"
	content="504163670361-prsa2jkhfsj131se147vtlgc8e41cfuk.apps.googleusercontent.com">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body{
    margin: 0;
    padding: 0;
    
    background-position: center;
    font-family: sans-serif;
}

.background-image{
background: url(${pageContext.request.contextPath}/resources/images/Rock-climbing-Wallpaper.jpg) no-repeat;
    background-size: cover;
    height:100vh;
    margin-top:-20px;
}

.loginbox{
    width: 320px;
    height: 420px;
    background: #000;
    color: #fff;
    top: 50%;
    left: 50%;
    margin-top:200px;
    position: absolute;
    transform: translate(-50%,-50%);
    box-sizing: border-box;
    padding: 70px 30px;
}

.avatar{
    width: 100px;
    height: 100px;
    border-radius: 50%;
    position: absolute;
    top: -50px;
    left: calc(50% - 50px);
}

h1{
    margin: 0;
    padding: 0 0 20px;
    text-align: center;
    font-size: 22px;
}

.loginbox p{
    margin: 0;
    padding: 0;
    font-weight: bold;
    font-size:20px;
}

.loginbox input{
    width: 100%;
    margin-bottom: 20px;
}

.loginbox input[type="text"], input[type="password"]
{
    border: none;
    border-bottom: 1px solid #fff;
    background: transparent;
    outline: none;
    height: 40px;
    color: #fff;
    font-size: 16px;
}
.loginbox input[type="submit"]
{
    border: none;
    outline: none;
    height: 40px;
    background: #fb2525;
    color: #fff;
    font-size: 18px;
    border-radius: 20px;
}
.loginbox input[type="submit"]:hover
{
    cursor: pointer;
    background: #ffc107;
    color: #000;
}
.loginbox a{
    text-decoration: none;
    font-size: 12px;
    line-height: 20px;
    color: darkgrey;
}

.dropdown-menu{
height:200px !important;
color:black;
}

.loginbox a:hover
{
    color: #ffc107;
}

.input_user,
		.input_pass:focus {
			box-shadow: none !important;
			outline: 0px !important;
		}
</style> 
</head>

<body>
<!-- header -->
	<jsp:include page="header.jsp"/>
	<c:if test="${not empty message}">	
	<div class="alert alert-danger">
	${message}
	</div>
	</c:if>
	 <div class="background-image">
 <div class="loginbox">
    <img src="${pageContext.request.contextPath}/resources/images/avatar.png" class="avatar">
        <h1>Login Here</h1>
        <form name='f' action="login" method='POST'>
            <p>Email</p>
            <input type="text"  id="ssoId" placeholder="Email" class="form-control input_user" value="" name="ssoId" required/>
      
       
       <p>Password</p>
            <input type="password"  class="form-control input_pass" id="password" name="password" value="" placeholder="Password" required/>
       
        <input type="submit" name="" value="${btnLabel}">
            <a href="${contextRoot}/getSignupForm">Don't have an account?</a>
            <input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
        </form>
        
        
    </div>
    </div>
	<jsp:include page="Footer.jsp" />
</body>
