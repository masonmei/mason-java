package org.personal.mason.component;

import org.personal.mason.dto.UserForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserFormValidation {

public boolean supports(Class<?> clazz) {
	return UserForm.class.isAssignableFrom(clazz);
}

public void registerValidate(Object target, Errors errors) {
	UserForm userForm = (UserForm) target;

	if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
		errors.rejectValue("passwordConfirm", "matchingPassword.registration.password", "Password not match!");
	}
}

}
