<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="pageTitle" value="OAuth Error" scope="request" />
<title><c:out value="${pageTitle }" /></title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" />
</head>

<body>
	<h1>OAuth2 Error</h1>

	<div id="content">
		<p>
			<c:out value="${message}" />
			(
			<c:out value="${error.summary}" />
			)
		</p>
		<p>Please go back to your client application and try again, or
			contact the owner and ask for support</p>
	</div>

	<div id="footer"></div>
</body>
</html>
