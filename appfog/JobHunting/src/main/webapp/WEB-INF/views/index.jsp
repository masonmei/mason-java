<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Hunting</title>

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.tools.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/app/common.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/standalone.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login/validator/form.css"/>">
</head>
<body>

	<form id="loginForm" novalidate="novalidate" method="post"
		action="login">
		<fieldset>
			<h3>Job Hunting Login</h3>
			<div class="message-header">
				<c:if test="${not empty msg }">
					<div id="message" class="message">${msg }</div>
				</c:if>
			</div>
			<p>
				<label>Email*</label> <input type="email" name="user.email"
					required="required" class="inputField" />
			</p>
			<p>
				<label>Password*</label> <input type="password" name="user.password"
					required="required" class="inputField">
			</p>
			<p>
				<label>Validation Code*</label> <input type="text"
					name="validationCode" required="required" class="inputField">
			</p>
			<p id="validation">
				<img src="validationCode" id="validationCode"
					onclick="javascript:refreshValidationCodeImage();" /><a
					onclick="javascript:refreshValidationCodeImage();">Change
					Image?</a>
			</p>
			<p id="savepassword">
				<label>Keep me login </label> <input type="checkbox"
					name="keepLogin" value="true" />
			</p>
			<button type="submit">Login</button>
			<button type="reset">Reset</button>
			<a href="register.jsp">register</a>
		</fieldset>
	</form>
</body>
</html>