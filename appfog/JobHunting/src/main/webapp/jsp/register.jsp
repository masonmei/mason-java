<%@page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>Register to be a User</title>

<script type="text/javascript" src="../javascript/jquery.tools.min.js"></script>
<script type="text/javascript" src="../app/common.js"></script>
<link rel="stylesheet" type="text/css"
	href="../css/standalone.css">
<link rel="stylesheet" type="text/css"
	href="../css/login/validator/form.css">
</head>
<body>
	<form id="registerForm" action="register" method="post">
		<fieldset>
			<h3>Job Hunting Register</h3>
			<p>
				<label>UserName</label> <input type="text" name="user.name" 
					class="inputField" placeholder="enter your user name">
			</p>
			<p>
				<label>Email*</label> <input type="email" name="user.email"
					class="inputField" placeholder="enter your email" autofocus required />
			</p>
			<p>
				<label>Password*</label> <input type="password" name="user.password"
					required class="inputField" placeholder="enter password">
			</p>
			<p>
				<label>Retype Password*</label> <input type="password"
					name="passwordConfirm" required class="inputField" placeholder="enter password again">
			</p>
			<p>
				<label>Validation Code*</label> <input type="text"
					name="validationCode" required class="inputField" placeholder="enter validation code">
			</p>
			<p id="validation">
				<img src="validationCode" id="validationCode"
					onclick="javascript:refreshValidationCodeImage();" /><a
					onclick="javascript:refreshValidationCodeImage();">Change
					Image?</a>
			</p>

			<button type="reset">Reset</button>
			<button type="submit" autofocus="autofocus">Register</button>

		</fieldset>
	</form>
</body>
</html>