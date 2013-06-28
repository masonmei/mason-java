<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pageTitle" value="Signup" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><c:out value="${pageTitle }" /></title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/default.css"/>" />

</head>
<body>
	<div id="container">
		<div id="header">
			<div id="header-left">Open Auth Platform</div>
		</div>

		<div id="content">
			<div id="content-header">
				<h2>Welcome to Signup OAuth Platform</h2>
			</div>
			<div id="content-body">
				<div id="login-form">
					<div id="login-form-header">User Information</div>
					<div id="login-form-content">
						<c:url value="/signup/new" var="newAction" />
						<form:form action="${newAction }" method="post"
							modelAttribute="signupForm" id="loginForm">
							<form:errors path="*" element="div" cssClass="alert alert-error" />
							<p>
								<label for="firstName">First Name</label>
								<form:input path="firstName" cssClass="input" id="firstName" />
							</p>
							<p>
								<label for="lastName">Last Name</label>
								<form:input path="lastName" cssClass="input" id="lastName" />
							</p>
							<p>
								<label for="email">Email(un)</label>
								<form:input path="email" cssClass="input" id="email" />
							</p>
							<p>
								<label for="password">Password</label>
								<form:password path="password" cssClass="input" id="password" />
							</p>
							<p>
								<input class="button" type="submit" value="Create Account" />
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">Copyright &copy 2013 oauth.com. All rights
		reserved.</div>
</body>
</html>