package org.personal.mason.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.domain.User;
import org.personal.mason.dto.UserForm;
import org.personal.mason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/register")
@SessionAttributes(value = { "userForm" })
public class UserController {

private static final Log log = LogFactory.getLog(UserController.class);

@Autowired
private UserService userService;

public void setUserService(UserService userService) {
	this.userService = userService;
}

@ModelAttribute("userForm")
public UserForm createUserForm() {
	return new UserForm();
}

@RequestMapping(method = RequestMethod.GET)
public void toRegister() {
}

@RequestMapping(method = RequestMethod.POST)
public String register(@Validated UserForm userForm, BindingResult result, HttpSession session) {
	try {
		if (result.hasErrors()) {
			return null;
		}
		String validatecode = (String) session.getAttribute("validationcode");
		if (validatecode == null || !validatecode.equalsIgnoreCase(userForm.getValidationCode())) {
			result.addError(new ObjectError("validationCode", "validation code error"));
			return null;
		}

		if (!userForm.getPasswordConfirm().equals(userForm.getPassword())) {
			result.addError(new ObjectError("validationCode", "password not match"));
			return null;
		}

		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setName(userForm.getName());
		user.setPassword(userForm.getPassword());
		userService.register(user);
		return "redirect:/index";
	} catch (Exception e) {
		log.debug("regist failed", e);
		result.addError(new ObjectError("*", "unknow error"));
	}

	return null;
}
}
