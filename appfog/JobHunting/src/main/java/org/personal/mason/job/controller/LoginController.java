package org.personal.mason.job.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.job.domain.User;
import org.personal.mason.job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value={"userForm"})
public class LoginController {
	static final String SESSION_TOKEN = "accountid";
	private static final int expiry = 24 * 3600 * 14;
	private static final Log log = LogFactory.getLog(LoginController.class);

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ModelAttribute("userForm")
	public UserForm createUserForm(){
		return new UserForm();
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String root() {
		return "redirect:/index";
	}
	
	@RequestMapping(value="index", method = RequestMethod.GET)
	public void index() {
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@Valid UserForm userForm, BindingResult result, HttpSession session, HttpServletResponse response) {

		try {
			if (result.hasErrors()) {
				return "index";
			}

			String validatecode = (String) session.getAttribute("validationcode");
			if (validatecode == null || !validatecode.equalsIgnoreCase(userForm.getValidationCode())) {
				result.addError(new ObjectError("validationCode", "validation code error"));
				return "index";
			}

			User user = new User(userForm.getEmail(), userForm.getPassword());

			if (userService.verifyUser(user)) {
				session.setAttribute(SESSION_TOKEN, user.getEmail());
				if (userForm.isKeepLogin()) {
					session.setMaxInactiveInterval(expiry);
					session.setAttribute("email", userForm.getEmail());
					Cookie cookie = new Cookie("JSESSIOINID", session.getId());
					cookie.setMaxAge(expiry);
					response.addCookie(cookie);
				}

				return "welcome";
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
}
