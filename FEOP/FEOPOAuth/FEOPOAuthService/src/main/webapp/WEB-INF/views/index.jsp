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
<c:set var="pageTitle" value="Open Auth Platform" scope="request" />
<title><c:out value="${pageTitle }" /></title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/default.css"/>" />

</head>
<body>
	<div id="container">
		<div id="header">
			<div id="header-left">Open Auth Platform</div>
			<div id="header-right">
				<authz:authorize ifAllGranted="ROLE_USER">
					<div style="text-align: center">

						<a href="<c:url value="/oauth/logout.do"/>">Logout</a>
					</div>
				</authz:authorize>
				<authz:authorize ifNotGranted="ROLE_USER">
					<a href="<c:url value="/signup/"/>">Signup</a>
				</authz:authorize>
			</div>
		</div>

		<div id="content">
			<div id="content-header">
				<h2>Welcome to OAuth Platform</h2>
			</div>
			<authz:authorize ifNotGranted="ROLE_USER">
				<div id="login-form">
					<div id="login-form-header">Welcome to login Open Auth
						Platform</div>
					<div id="login-form-content">
						<form id="loginForm" name="loginForm"
							action="<c:url value="/oauth/login.do"/>" method="post">
							<p>
								<label>Email: <input class="input" type='text'
									name='j_username'></label>
							</p>
							<p>
								<label>Secret: <input class="input" type="password"
									name='j_password'></label>
							</p>
							<p>
								<input class="button" name="login" value="Login" type="submit">
								<input class="button" name="reset" value="Reset" type="reset">
							</p>
						</form>
					</div>
				</div>
			</authz:authorize>
		</div>
	</div>
	<div id="footer">Copyright &copy 2013 oauth.com. All rights
		reserved.</div>
</body>
</html>
