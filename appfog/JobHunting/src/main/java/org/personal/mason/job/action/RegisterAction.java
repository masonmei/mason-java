package org.personal.mason.job.action;

import org.personal.mason.job.domain.User;
import org.personal.mason.job.service.UserService;

public class RegisterAction extends AbstractAction {
private static final long serialVersionUID = -7381734524828715949L;
private UserService userService;
private User user = new User();
private String validationCode;
private String passwordConfirm;
private String msg;
private boolean success;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public String getValidationCode() {
	return validationCode;
}

public String getPasswordConfirm() {
	return passwordConfirm;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public void setSuccess(boolean success) {
	this.success = success;
}

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

public void setPasswordConfirm(String passwordConfirm) {
	this.passwordConfirm = passwordConfirm;
}

@Override
public String process() {
	try {
		String validatecode = (String) session.getAttribute("validationcode");
		if (validatecode == null || !validatecode.equalsIgnoreCase(validationCode)) {
			msg = "validation code error";
			success = false;
			return "result";
		}

		if (!passwordConfirm.equals(user.getPassword())) {
			msg = "password not match";
			success = false;
			return "result";
		}

		userService.save(user);
		msg = "register success";
		success = true;

	} catch (Exception e) {
		log.debug("regist failed", e);
	}
	return "result";
}

}
