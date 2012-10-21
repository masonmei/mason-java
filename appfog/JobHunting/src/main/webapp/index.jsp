<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Hunting</title>

<script type="text/javascript" src="javascript/jquery.tools.min.js"></script>
<script type="text/javascript" src="app/common.js"></script>
<link rel="stylesheet" type="text/css" href="css/login/standalone.css">
<link rel="stylesheet" type="text/css"
	href="css/login/validator/form.css">
</head>
<body>

	<form id="loginForm" novalidate="novalidate">
		<fieldset>
			<h3>Job Hunting Login</h3>
			<p>
				<label>Email*</label> <input type="email" name="email"
					required="required" class="inputField" />
			</p>
			<p>
				<label>Password*</label> <input type="password" name="password"
					required="required" class="inputField">
			</p>
			<p>
				<label>Validation Code*</label> <input type="text"
					name="validatecode" required="required" class="inputField">
			</p>
			<p id="validation">
				<img src="validationCode" id="validationCode"
					onclick="javascript:refreshValidationCodeImage();" /><a
					onclick="javascript:refreshValidationCodeImage();">Change
					Image?</a>
			</p>
			<p id="savepassword">
				<label>Keep me login </label> <input type="checkbox" />
			</p>
			<button type="submit">Login</button>
			<button type="reset">Reset</button>
			<a href="jsp/register.jsp">register</a>
		</fieldset>
	</form>
	<script>
		$("#loginForm").validator();
	</script>
</body>
</html>