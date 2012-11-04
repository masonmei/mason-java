package org.personal.mason.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.domain.User;
import org.personal.mason.dto.UserForm;
import org.personal.mason.service.UserService;
import org.personal.mason.utils.Constants;
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
@SessionAttributes(value = { "userForm" })
public class LoginController {
private static final Log log = LogFactory.getLog(LoginController.class);

@Autowired
private UserService userService;

public void setUserService(UserService userService) {
	this.userService = userService;
}

@ModelAttribute("userForm")
public UserForm createUserForm() {
	return new UserForm();
}

@RequestMapping(value = "/", method = RequestMethod.GET)
public String root() {
	return "redirect:/index";
}

@RequestMapping(value = "index", method = RequestMethod.GET)
public void index() {
}

@RequestMapping(value = "login", method = RequestMethod.POST)
public String login(@Validated UserForm userForm, BindingResult result, HttpSession session, HttpServletResponse response) {

	try {
		if (result.hasErrors()) {
			return "index";
		}

		String validatecode = (String) session.getAttribute("validationcode");
		if (validatecode == null || !validatecode.equalsIgnoreCase(userForm.getValidationCode())) {
			result.addError(new ObjectError("validationCode", "validation code error"));
			return "index";
		}

		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		if (userService.verifyUser(user)) {
			session.setAttribute(Constants.SESSION_TOKEN, user.getEmail());
			if (userForm.isKeepLogin()) {
				session.setMaxInactiveInterval(Constants.EXPIRY);
				session.setAttribute("email", userForm.getEmail());
				Cookie cookie = new Cookie("JSESSIOINID", session.getId());
				cookie.setMaxAge(Constants.EXPIRY);
				response.addCookie(cookie);
			}

			return "redirect:/welcome";
		} else {
			result.addError(new ObjectError("*", "username or password incorrect"));
			return "index";
		}
	} catch (Exception e) {
		log.debug("login failed", e);
		result.addError(new ObjectError("*", e.getMessage()));
	}

	return "index";
}

@RequestMapping(value = "welcome", method = RequestMethod.GET)
public String welcome() {
	return "welcome";
}

@RequestMapping(value = { "logout" }, method = RequestMethod.GET)
public String logout(HttpSession session, HttpServletResponse response) {
	session.removeAttribute(Constants.SESSION_TOKEN);
	return "index";
}
}
