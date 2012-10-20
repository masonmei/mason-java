package org.personal.mason.job.action;

import javax.servlet.http.Cookie;

import org.personal.mason.job.domain.User;
import org.personal.mason.job.service.UserService;

import com.opensymphony.xwork2.ModelDriven;

public class UserLoginAction extends AbstractAction implements ModelDriven<User> {

private static final long serialVersionUID = 3446529593029200967L;
private static final int expiry = 24 * 3600 * 14;

private UserService userService;
private User user = new User();
private String validationCode;
private boolean keepLogin;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setUserService(UserService userService) {
	this.userService = userService;
}

public void setValidationCode(String validationCode) {
	this.validationCode = validationCode;
}

public void setKeepLogin(boolean keepLogin) {
	this.keepLogin = keepLogin;
}

@Override
public String process() {
	try {
		String sessionValidationCode = (String) session.getAttribute("validationcode");
		if (!sessionValidationCode.equalsIgnoreCase(validationCode)) {
			success = false;
			msg = "Validation Code not Correct";
			return "result";
		}
		if (userService.verifyUser(user)) {
			success = true;
			if (keepLogin) {
				keepLogin();
			}
			msg = "login success";
		} else {
			success = false;
			msg = "username or password incorrect";
		}
	} catch (Exception e) {
		log.debug("login failed", e);
	}
	return "result";
}

private void keepLogin() {
	session.setMaxInactiveInterval(expiry);
	session.setAttribute("email", user.getEmail());
	Cookie cookie = new Cookie("JSESSIOINID", session.getId());
	cookie.setMaxAge(expiry);
	response.addCookie(cookie);
}

@Override
public User getModel() {
	return user;
}

}
