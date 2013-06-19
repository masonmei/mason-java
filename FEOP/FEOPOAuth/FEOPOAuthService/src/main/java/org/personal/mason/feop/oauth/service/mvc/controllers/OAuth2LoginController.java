package org.personal.mason.feop.oauth.service.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OAuth2LoginController {

	@RequestMapping("login")
	public String login(@RequestParam(value = "authorization_error", required = false) boolean error, Model model) {
		if (error) {
			model.addAttribute("error", "You have entered an invalid username or password!");
		}
		return "login";
	}

	@RequestMapping("logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping(value = { "/", "index" })
	public String index() {
		return "index";
	}

	@RequestMapping("request_token_authorized")
	public String request_token_authorized() {
		return "request_token_authorized";
	}

}
