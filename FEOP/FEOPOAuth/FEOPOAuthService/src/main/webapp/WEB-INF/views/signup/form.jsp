<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pageTitle" value="Signup" scope="request" />
<!DOCTYPE html>
<html>
<head>
<title><c:out value="${pageTitle }" /></title>
</head>
<body>
	<form:form action="./new" method="post" modelAttribute="signupForm">
		<form:errors path="*" element="div" cssClass="alert alert-error" />
		<fieldset>
			<legend>User Information</legend>
			<label for="firstName">First Name</label>
			<form:input path="firstName" id="firstName" />
			<label for="lastName">Last Name</label>
			<form:input path="lastName" id="lastName" />
			<label for="email">Email (UserName)</label>
			<form:input path="email" id="email" />
			<label for="password">Password</label>
			<form:password path="password" id="password" />
			<div>
				<input id="submit" type="submit" value="Create Account" />
			</div>
		</fieldset>
	</form:form>
</body>
</html>