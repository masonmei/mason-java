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
</head>
<body>
	<form:form action="./create" method="post" modelAttribute="clientForm">
		<form:errors path="*" element="div" cssClass="alert alert-error" />
		<fieldset>
			<legend>User Information</legend>
			<label for="clientName">Client Name</label>
			<form:input path="clientName" id="clientName" />
			<label for="clientType">Client Type</label>
			<form:radiobuttons path="clientType" items="${client_types }" />
			<label for="redirectUrl">Redirect Url</label>
			<form:input path="redirectUrl" id="redirectUrl"/>
			<div>
				<input id="submit" type="submit" value="Create Account" />
			</div>
		</fieldset>
	</form:form>
</body>
</html>