<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="pageTitle" value="Please Login" scope="request" />
<c:url value="/oauth/login.do" var="loginUrl" />
<title><c:out value="${pageTitle }" /></title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
	<div id="content">
		<form action="${loginUrl}" method="post">
			<c:if test="${param.error != null}">
				<div class="alert alert-error">
					Failed to login.
					<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
              Reason: <c:out
							value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</c:if>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">You have been logged out.</div>
			</c:if>
			<label for="username">Username</label> <input type="text"
				id="username" name="j_username" /> <label for="password">Password</label>
			<input type="password" id="password" name="j_password" />
			<div class="form-actions">
				<input id="submit" class="btn" name="submit" type="submit"
					value="Login" />
			</div>
		</form>
	</div>
</body>
</html>