<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>

<script type="text/javascript" src="javascript/jquery.tools.min.js"></script>
<script type="text/javascript" src="app/common.js"></script>
<link rel="stylesheet" type="text/css" href="css/login/standalone.css">
<link rel="stylesheet" type="text/css"
	href="css/login/validator/form.css">
</head>
<body>

	<fieldset>
		<s:form action="login" title="Job Hunting Login">

			<s:textfield name="email" label="Email*" labelposition="top" />
			<s:password name="password" label="password*" labelposition="top" />
			<s:textfield name="vcode" lable="Validation Code*"
				labelposition="top" />
			<img src="validationCode" id="validationCode"
				onclick="javascript:refreshValidationCodeImage();"
				title="Change Image?" />
			<s:checkbox name="keepMeLogin" label="Keep me Login"
				labelposition="left" />
			<s:submit />
			<s:reset />
			<s:a value="register" href="register" />

		</s:form>
	</fieldset>

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
				onclick="javascript:refreshValidationCodeImage();">Change Image?</a>
		</p>
		<p id="savepassword">
			<label>Keep me login </label> <input type="checkbox" />
		</p>
		<button type="submit">Login</button>
		<button type="reset">Reset</button>
		<a href="register">register</a>
	</fieldset>


</body>
</html>