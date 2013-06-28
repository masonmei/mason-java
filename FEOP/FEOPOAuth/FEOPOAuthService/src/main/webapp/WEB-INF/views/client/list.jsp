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

<title>Open Auth Platform - My Applications</title>
<link rel="stylesheet" href="${defaultCss }" />
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
				<h2>My Applications</h2>
			</div>

			<div id="content-body">
				<c:forEach items="${applications}" var="app">
					<div style="margin: 5px;">
						<div class="widget">
							<div class="widget-header">
								<c:out value="${app.clientId }" />
							</div>
							<div class="widget-body">
								<div>
									<label>Application Id:</label><label><c:out
											value="${app.clientId }" /></label>
								</div>
								<div>
									<label>Client Secret:</label><label><c:out
											value="${app.clientSecret }" /></label>
								</div>
								<div>
									<label>Authorized Grant Types:</label><label><c:out
											value="${app.authorizedGrantTypes }" /></label>
								</div>
								<div>
									<label>Authorities:</label><label><c:out
											value="${app.authorities }" /></label>
								</div>
								<div>
									<label>Resource Ids:</label><label><c:out
											value="${app.resourceIds }" /></label>
								</div>
								<div>
									<label>Scope:</label><label><c:out
											value="${app.clientId }" /></label>
								</div>
								<div>
									<label>Redirect Uri:</label><label><c:out
											value="${app.scope }" /></label>
								</div>
								<div>
									<label>Additional Info:</label><label><c:out
											value="${app.additionalInfo }" /></label>
								</div>
								<div>
									<a href='<c:url value="/client/delete/${app.clientId }"/>'>Delete</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<div id="footer">Copyright &copy 2013 oauth.com. All rights
		reserved.</div>
</body>
</html>