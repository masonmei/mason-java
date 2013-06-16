<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sparklr</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/style.css"/>" />
</head>

<body>

	<h1>开放平台</h1>

	<div id="content">
		<c:if test="${not empty param.authentication_error}">
			<h1>Woops!</h1>

			<p class="error">Your login attempt was not successful.</p>
		</c:if>
		<c:if test="${not empty param.authorization_error}">
			<h1>Woops!</h1>

			<p class="error">You are not permitted to access that resource.</p>
		</c:if>

		<h2>登录</h2>
		
		<p>默认邮箱为13911722490，密码为123456</p>
		<form id="loginForm" name="loginForm"
			action="<c:url value="/oauth/login.do"/>" method="post">
			<p>
				<label>邮箱: <input type='text' name='j_username'
					value="13911722490" /></label>
			</p>
			<p>
				<label>密码: <input type='text' name='j_password'
					value="123456" /></label>
			</p>

			<p>
				<input name="login" value="登录" type="submit"/>
			</p>
		</form>
	</div>

	<div id="footer">iqiyi OAuth2.0</div>
</body>
</html>
