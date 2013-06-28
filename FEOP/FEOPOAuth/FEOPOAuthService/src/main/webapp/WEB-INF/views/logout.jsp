<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="pageTitle" value="Logout" scope="request" />
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
				<h2>Logout Open Auth Platform</h2>
			</div>
			<div id="content-body">
				<h1>You have been logout!</h1>
			</div>
		</div>
	</div>
	<div id="footer">Copyright &copy 2013 oauth.com. All rights
		reserved.</div>
</body>
</html>