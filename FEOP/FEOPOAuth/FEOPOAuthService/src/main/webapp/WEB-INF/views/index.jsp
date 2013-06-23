<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="pageTitle" value="OAuth Platform" scope="request" />
<title><c:out value="${pageTitle }" /></title>
<title>OAuth Platform</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" />

<authz:authorize ifAllGranted="ROLE_USER">
	<script type='text/javascript'>
		function pictureDisplay(json) {
			for ( var i = 0; i < json.photos.length; i++) {
				var photo = json.photos[i];
				document
						.write('<img src="photos/' + photo.id + '" alt="' + photo.name + '">');
			}
		}
	</script>
</authz:authorize>
</head>
<body>
	<h1>Open Auth Platform</h1>
	<div id="content">
		<h2>Welcome to OAuth Platform</h2>

		<authz:authorize ifNotGranted="ROLE_USER">
			<h2>Login</h2>
			<form id="loginForm" name="loginForm"
				action="<c:url value="/oauth/login.do"/>" method="post">
				<p>
					<label>Email: <input type='text' name='j_username'></label>
				</p>
				<p>
					<label>Secret: <input type="password" name='j_password'></label>
				</p>

				<p>
					<input name="login" value="Login" type="submit">
				</p>
			</form>
		</authz:authorize>
		<authz:authorize ifAllGranted="ROLE_USER">
			<div style="text-align: center">
				<form action="<c:url value="/oauth/logout.do"/>">
					<input type="submit" value="Logout">
				</form>
			</div>

			<h2>Your personal information</h2>
			<p>
				<script type='text/javascript'
					src='photos.do?callback=pictureDisplay&format=json'></script>
			</p>
		</authz:authorize>
	</div>

	<div id="footer">OAuth2.0</div>
</body>
</html>
