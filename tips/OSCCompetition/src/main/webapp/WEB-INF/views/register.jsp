<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Register to be a User</title>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>' />
<meta charset="UTF-8">
</head>
<body>
	<div id="register-box">
		<f:form method="post" class="signin" action="register"
			modelAttribute="account">
			<fieldset class="textbox">
				<p>
					<label>UserName<f:errors path="username" cssClass="error" /></label>
					<f:input path="username" class="" alt="enter your user name" />
				</p>
				<p>
					<label>Email* <f:errors path="email" cssClass="error" /></label>
					<f:input path="email" class="" alt="enter your email" />
				</p>
				<p>
					<label>Account <f:errors path="account" cssClass="error" /></label>
					<f:input path="account" class="" alt="enter your account name" />
				</p>
				<p>
					<label>Password* <f:errors path="secret" cssClass="error" /></label>
					<f:password path="secret" class="inputField" alt="enter password" />
				</p>

				<button type="reset">Reset</button>
				<button type="submit" autofocus="autofocus">Register</button>
			</fieldset>
		</f:form>
	</div>
</body>
</html>