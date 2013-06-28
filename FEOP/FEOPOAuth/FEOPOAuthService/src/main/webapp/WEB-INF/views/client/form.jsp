<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pageTitle" value="Create Application" scope="request" />
<!DOCTYPE html>
<html>
<head>
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
				<h2>Create Application</h2>
			</div>
			<div id="login-form">
				<div id="login-form-header">Application Information</div>
				<div id="login-form-content">
					<c:url value="/client/create" var="newAction" />
					<form:form action="${newAction }" method="post"
						modelAttribute="clientForm">
						<form:errors path="*" element="div" cssClass="alert alert-error" />
						<p>
							<label for="clientName">Client Name</label>
							<form:input path="clientName" id="clientName" cssClass="input" />
						</p>
						<p>
							<label for="clientType">Client Type</label>
							<form:radiobuttons path="clientType" items="${client_types }"
								cssClass="input" />
						</p>
						<p>
							<label for="redirectUrl">Redirect Url</label>
							<form:input path="redirectUrl" id="redirectUrl" cssClass="input" />
						</p>
						<p>
							<input id="submit" type="submit" value="Create Account"
								class="button" />
						</p>
					</form:form>
				</div>
			</div>
		</div>
		<div id="footer">Copyright &copy 2013 oauth.com. All rights
			reserved.</div>
</body>
</html>