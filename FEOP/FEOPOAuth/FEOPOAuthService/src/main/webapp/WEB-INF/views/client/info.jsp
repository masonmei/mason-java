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
</head>
<body>
	<div>
		<fieldset>
			<label>Client Id: <c:out value="${client.clientId }"/></label>
			<label>Secret:	<c:out value="${client.clientSecret }"/></label>
		</fieldset>
	</div>
</body>
</html>