<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title>OAuth Platform</title>
  <link type="text/css" rel="stylesheet" href="<c:url value="/style.css"/>"/>

  <authz:authorize ifAllGranted="ROLE_USER">
    <script type='text/javascript'>
      function pictureDisplay(json) {
        for (var i = 0; i < json.photos.length; i++) {
          var photo = json.photos[i];
          document.write('<img src="photos/' + photo.id + '.do" alt="' + photo.name + '">');
        }
      }
    </script>
  </authz:authorize>
</head>
<body>

  <h1>Open Platform</h1>

  <div id="content">
    <h2>Welcome</h2>

    <authz:authorize ifNotGranted="ROLE_USER">
      <h2>Login</h2>
      <p>默认邮箱为13911722490，密码为123456</p>
      <form id="loginForm" name="loginForm" action="<c:url value="/oauth/login.do"/>" method="post">
        <p><label>邮箱: <input type='text' name='j_username' value="13911722490"></label></p>
        <p><label>密码: <input type='text' name='j_password' value="123456"></label></p>
        
        <p><input name="login" value="登录" type="submit"></p>
      </form>
    </authz:authorize>
    <authz:authorize ifAllGranted="ROLE_USER">
      <div style="text-align: center"><form action="<c:url value="/oauth/logout.do"/>"><input type="submit" value="Logout"></form></div>
      
      <h2>您的个人信息</h2>

      <p>
        <script type='text/javascript' src='photos.do?callback=pictureDisplay&format=json'></script>
      </p>
    </authz:authorize>
  </div>

  <div id="footer">OAuth2.0</div>


</body>
</html>
