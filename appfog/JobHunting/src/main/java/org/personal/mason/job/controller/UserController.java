package org.personal.mason.job.controller;

import org.personal.mason.job.domain.User;
import org.personal.mason.job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String toRegister() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user,
			BindingResult result) {
		// userService.save(user);
		return "redirect:index";
	}
}
