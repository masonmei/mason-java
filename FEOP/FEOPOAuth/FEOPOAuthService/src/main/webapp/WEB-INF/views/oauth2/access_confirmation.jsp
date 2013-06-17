<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ page
	import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page
	import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="pageTitle" value="Access Confirmation" scope="request" />
<title><c:out value="${pageTitle }" /></title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" />
<style type="text/css">
form input {
	width: 80px;
	height: 30px;
}
</style>
</head>
<body>
	<div id="content">
		<%
			if (session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null
					&& !(session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) instanceof UnapprovedClientAuthenticationException)) {
		%>
		<div class="error">
			<h2>Woops!</h2>

			<p>
				Access could not be granted. (<%=((AuthenticationException) session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY))
						.getMessage()%>)
			</p>
		</div>
		<%
			}
		%>
		<c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION" />

		<authz:authorize ifAllGranted="ROLE_USER">
			<h2>Please Authorize:</h2>

			<p>
				Please Authorize "
				<c:out value="${client.clientId}" />
				" to visit your resources.
			</p>

			<form id="confirmationForm" name="confirmationForm"
				action="<%=request.getContextPath()%>/oauth/authorize" method="post">
				<input name="user_oauth_approval" value="true" type="hidden" /> <label><input
					name="authorize" value="Authorize" type="submit"></label>
			</form>
			<form id="denialForm" name="denialForm"
				action="<%=request.getContextPath()%>/oauth/authorize" method="post">
				<input name="user_oauth_approval" value="false" type="hidden" /> <label><input
					name="deny" value="Cancel" type="submit"></label>
			</form>
		</authz:authorize>
	</div>

	<div id="footer"></div>
</body>
</html>