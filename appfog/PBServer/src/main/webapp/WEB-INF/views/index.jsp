<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Hunting</title>

<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery.tools.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/app/common.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/frame.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/login/form.css"/>">
</head>
<body id="framebody">

	<f:form id="loginForm" method="post" action="login"
		modelAttribute="userForm">
		<fieldset>
			<h3>Job Hunting Login</h3>
			<div class="header">
				<s:bind path="*">
					<c:if test="${status.error}">
						<div id="message" class="error">please fix the following
							errors</div>
					</c:if>
				</s:bind>
			</div>
			<p>
				<label>Email* <f:errors path="email" cssClass="error" /></label>
				<f:input path="email" class="inputField" alt="enter your email" />
			</p>
			<p>
				<label>Password* <f:errors path="password" cssClass="error" /></label>
				<f:password path="password" class="inputField" alt="enter password" />
			</p>
			<p>
				<label>Validation Code* <f:errors path="validationCode"
						cssClass="error" /></label>
				<f:input path="validationCode" class="inputField"
					alt="enter validation code" />
			</p>
			<p>
				<img src='<c:url value="validationCode"/>' id="validation"
					onclick="javascript:refreshValidationCodeImage();" /><a
					onclick="javascript:refreshValidationCodeImage();">Change
					Image?</a>
			</p>
			<p id="savepassword">
				<label>Keep me login </label>
				<f:checkbox path="keepLogin" value="true" />
			</p>
			<button type="submit">Login</button>
			<button type="reset">Reset</button>
			<a href="register">register</a>
		</fieldset>
	</f:form>
</body>
</html>