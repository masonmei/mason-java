package org.personal.mason.feop.oauth.service.mvc.controllers;

import javax.validation.Valid;

import org.personal.mason.feop.oauth.service.domain.OauthUser;
import org.personal.mason.feop.oauth.service.mvc.model.SignupForm;
import org.personal.mason.feop.oauth.service.spi.OUserContext;
import org.personal.mason.feop.oauth.service.spi.OUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignupController {

	private final OUserContext userContext;
	private final OUserService userService;

	@Autowired
	public SignupController(OUserContext userContext, OUserService userService) {
		if (userContext == null) {
			throw new IllegalArgumentException("User Context cannot be null");
		}
		if (userService == null) {
			throw new IllegalArgumentException("User Service cannot be null");
		}
		this.userContext = userContext;
		this.userService = userService;
	}

	@RequestMapping("/signup/form")
	public String signup(@ModelAttribute SignupForm signupForm) {
		return "signup/form";
	}

	@RequestMapping(value = "/signup/new", method = RequestMethod.POST)
	public String signup(@Valid SignupForm signupForm, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "signup/form";
		}

		String email = signupForm.getEmail();
		if (userService.findByEmailOrUsername(email) != null) {
			result.rejectValue("email", "errors.signup.email",
					"Email address already in use.");
			return "signup/form";
		}

		OauthUser user = userService.createUser(signupForm);
		userService.regist(user);
		userContext.setCurrentUser(user);

		redirectAttributes.addFlashAttribute("message", "You have successfully signed up and logged in.");
		return "redirect:/";
	}
}
