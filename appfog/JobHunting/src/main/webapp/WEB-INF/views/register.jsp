<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Register to be a User</title>

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.tools.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/app/common.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/standalone.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login/form.css"/>">

</head>
<body>
	<f:form id="registerForm" action="register" method="post" modelAttribute="userForm">
		<fieldset>
			<h3>Job Hunting Register</h3>
			<div class="header">		  		
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">please fix the following errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
			<p>
				<label>UserName<f:errors path="name" cssClass="error" /></label>
				<f:input path="name" class="inputField" alt="enter your user name"/>
			</p>
			<p>
				<label>Email* <f:errors path="email" cssClass="error" /></label> 
				<f:input path="email" class="inputField" alt="enter your email" />
			</p>
			<p>
				<label>Password* <f:errors path="password" cssClass="error" /></label> 
				<f:password path="password" class="inputField" alt="enter password"/>
			</p>
			<p>
				<label>Retype Password* <f:errors path="passwordConfirm" cssClass="error" /></label> 
				<f:password path="passwordConfirm" class="inputField" alt="enter password again"/>
			</p>
			<p>
				<label>Validation Code* <f:errors path="validationCode" cssClass="error" /></label> 
				<f:input path="validationCode" class="inputField" alt="enter validation code"/>
			</p>
			<p>
				<img src="validationCode" id="validation"
					onclick="javascript:refreshValidationCodeImage();" /><a
					onclick="javascript:refreshValidationCodeImage();">Change
					Image?</a>
			</p>

			<button type="reset">Reset</button>
			<button type="submit" autofocus="autofocus">Register</button>

		</fieldset>
	</f:form>
</body>
</html>