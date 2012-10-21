package org.personal.mason.job.action;

import javax.servlet.http.Cookie;

import org.personal.mason.job.domain.User;
import org.personal.mason.job.service.UserService;

public class UserLoginAction extends AbstractAction {

private static final long serialVersionUID = 3446529593029200967L;
private static final int expiry = 24 * 3600 * 14;

private UserService userService;
private User user = new User();
private String validationCode;
private Boolean keepLogin;
private String msg;
private boolean success;

public UserService getUserService() {
	return userService;
}

public void setUserService(UserService userService) {
	this.userService = userService;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public String getValidationCode() {
	return validationCode;
}

public void setValidationCode(String validationCode) {
	this.validationCode = validationCode;
}

public Boolean getKeepLogin() {
	return keepLogin;
}

public void setKeepLogin(Boolean keepLogin) {
	this.keepLogin = keepLogin;
	if(keepLogin == null){
		this.keepLogin = Boolean.FALSE;
	}
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public boolean isSuccess() {
	return success;
}

public void setSuccess(boolean success) {
	this.success = success;
}

@Override
public String process() {
	try {
		String sessionValidationCode = (String) session.getAttribute("validationcode");
		if (!sessionValidationCode.equalsIgnoreCase(validationCode)) {
			success = false;
			msg = "Validation Code not Correct";
			return "input";
		}
		if (userService.verifyUser(user)) {
			success = true;
			setEmailToSession();
			if (keepLogin != null && keepLogin) {
				keepLogin();
			}
		} else {
			success = false;
			msg = "username or password incorrect";
			return "input";
		}
	} catch (Exception e) {
		log.debug("login failed", e);
	}
	return "result";
}

private void setEmailToSession() {
	session.setAttribute(SESSION_TOKEN, user.getEmail());
}

private void keepLogin() {
	session.setMaxInactiveInterval(expiry);
	session.setAttribute("email", user.getEmail());
	Cookie cookie = new Cookie("JSESSIOINID", session.getId());
	cookie.setMaxAge(expiry);
	response.addCookie(cookie);
}

}
