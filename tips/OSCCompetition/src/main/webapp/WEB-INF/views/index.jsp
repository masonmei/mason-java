<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>' />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
<script src='<c:url value="/resources/js/login.js"/>'></script>

</head>
<body>
	<!-- Top line start -->
	<div id="bar">
		<div id="container">
			<div id="siteHead">
				<h2>Header</h2>
			</div>
			<c:choose>
				<c:when test="${!empty currentUser}">
					<div class="btn-sign">
						<a href="<c:url value="/account/logout"/>" target="_top">Logout</a>
					</div>
				</c:when>
				<c:otherwise>
					<!-- Login Starts Here -->
					<div id="loginContainer">
						<a href="#" id="loginButton"><span>Login</span><em></em></a>
						<div style="clear: both"></div>
						<div id="loginBox">
							<form id="loginForm" method="post" action="account/login"
								target="_top">
								<fieldset id="body">
									<fieldset>
										<label for="email">Account or Email</label><input type="text"
											name="email" id="email" />
									</fieldset>
									<fieldset>
										<label for="password">Password</label> <input type="password"
											name="secret" id="password" />
									</fieldset>
									<input type="submit" id="login" value="Sign in" />
									<div id="registerButton">
										<a href="<c:url value="/account/register"></c:url>"
											target="_top">Register</a>
									</div>
								</fieldset>
								<span><a href="#">Forgot your password?</a></span>
							</form>
						</div>
					</div>
					<!-- Login Ends Here -->
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<!-- Top line end -->

	<div>
		<div class="category">
			<c:if test="${!empty categories}">
				<c:forEach var="cat" items="${categories }">
					<a href='<c:url value="/category/images?id=${cat.id }&page=0"/>'
						target="imagesView"> <span>${cat.categoryName }</span>
					</a>
				</c:forEach>
			</c:if>
			<c:if test="${!empty currentUser}">
				<div>
					<a>++++++</a>
				</div>
			</c:if>
		</div>
		<div>
			<form action="category/add" method="post">
				<fieldset id="body">
					<fieldset>
						<label for="categoryName">Category Name</label><input type="text"
							name="categoryName" id="email" />
					</fieldset>
					<fieldset>
						<label for="publicPrivilege">Public</label> <input type="checkbox"
							name="publicPrivilege" id="publicPrivilege" />
					</fieldset>
					<input type="submit" value="Create" id="registerButton" />
				</fieldset>
			</form>
		</div>
	</div>

	<div>
		<iframe src="<c:url value="/images"/>" name="imagesView"
			id="imageView" frameborder="0" width="100%" height="100%"></iframe>
	</div>
</body>
</html>