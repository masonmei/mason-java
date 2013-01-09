<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>Favorite Photo Gallge</title>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>

</head>
<body>
	<header tabindex="0">
		<div>
			<div id="content">
				<div class="post">
					<c:choose>
						<c:when test="${!empty currentUser}">
							<div class="btn-sign">
								<a href="<c:url value="/account/logout"/>">Logout</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="btn-sign">
								<a href="#login-box" class="login-window">Sign In</a>
							</div>
							<div class="btn-sign">
								<a href="<c:url value="/account/register"></c:url>">Register</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

				<div id="login-box" class="">
					<a href="#" class="close"><img
						src="<c:url value="/resources/images/close_pop.png"/>"
						class="btn_close" title="Close Window" alt="Close" /></a>
					<f:form id="loginForm" method="post" action="account/login"
						class="signin" modelAttribute="account">
						<fieldset class="textbox">
							<label class="username"> <span>Account or Email</span> <f:input
									path="email" class="inputField" alt="enter your email" />
							</label> <label class="password"> <span>Password</span> <f:password
									path="secret" class="inputField" alt="enter password" />
							</label>

							<button type="submit">Login</button>
						</fieldset>
					</f:form>
				</div>


			</div>
		</div>
		<h2>To Be Add</h2>
	</header>

	<div class="category">
		<c:if test="${!empty categories}">
			<c:forEach var="cat" items="${categories }">
				<a href="#"><span>${cat.categoryName }</span></a>
			</c:forEach>
		</c:if>
		<c:if test="${!empty currentUser}">
			<div>
				<a>+</a>
			</div>
		</c:if>
	</div>

	<div>
		<div class="category">
			<div>
				<a><img src='<c:url value="/resources/images/add.png"></c:url>' /></a>
			</div>
			<div>
				<a href="#">Previous</a><a href="#">Next</a>
			</div>
		</div>
		<div class="gallery">
			<c:if test="${!empty images}">
				<c:forEach var="img" items="${images }">
					<a draggable="true"><img
						src="<c:url value="/image/thumbnail?id=${img.id }"/>"></a>
				</c:forEach>
			</c:if>
		</div>
		<script src="<c:url value="/resources/js/main.js"/>"></script>
		<div class="category">
			<a href="#">Previous</a><a href="#">Next</a>
		</div>
	</div>


	<div class="login-popup">
		<form action='<c:url value="/image/upload"></c:url>' method="post"
			enctype="multipart/form-data">
			<fieldset>
				<input type="file" name="uploadFile" /> <input type="submit"
					value="Upload" />
			</fieldset>
		</form>
	</div>
</body>
</html>