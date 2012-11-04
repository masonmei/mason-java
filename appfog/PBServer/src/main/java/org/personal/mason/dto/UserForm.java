package org.personal.mason.dto;


public class UserForm {
private String name;
private String email;
private String password;
private String passwordConfirm;
private String validationCode;

private boolean keepLogin;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPasswordConfirm() {
	return passwordConfirm;
}

public void setPasswordConfirm(String passwordConfirm) {
	this.passwordConfirm = passwordConfirm;
}

public String getValidationCode() {
	return validationCode;
}

public void setValidationCode(String validationCode) {
	this.validationCode = validationCode;
}

public boolean isKeepLogin() {
	return keepLogin;
}

public void setKeepLogin(boolean keepLogin) {
	this.keepLogin = keepLogin;
}
}
