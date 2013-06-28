<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pageTitle" value="Client Info" scope="request" />
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
			<div id="content-body">
				<div style="width: 300px; left:35%; position: relative;">
					<div class="widget">
						<div class="widget-header">Your Application Information</div>
						<div class="widget-body">
							<div>Please remember the following information for using.</div>
							<div><label>Client Id: <c:out value="${client.clientId }" /></label></div>
							<div><label>Secret: <c:out value="${client.clientSecret }" /></label></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">Copyright &copy 2013 oauth.com. All rights
		reserved.</div>
</body>
</html>