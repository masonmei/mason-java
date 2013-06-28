<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<c:url var="defaultCss" value="/resources/css/default.css" />

<title>Open Auth Platform</title>
<link rel="stylesheet" href="${defaultCss }" />
</head>
<body>
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
		<div id="content-body">
			<div id="login-form">
				<div id="login-form-header">Welcome to login Open Auth
					Platform</div>
				<div id="login-form-content">
					<form id="loginForm" name="loginForm" action="/oauth/login.do"
						method="post">
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
		</div>
		
		
	</div>

	<div id="footer">Copyright &copy 2013 oauth.com. All rights
		reserved.</div>
</body>
</html>