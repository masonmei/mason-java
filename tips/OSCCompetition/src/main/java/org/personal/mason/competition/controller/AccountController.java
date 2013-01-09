package org.personal.mason.competition.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.competition.domain.Account;
import org.personal.mason.competition.service.AccountService;
import org.personal.mason.competition.thirdparty.MailGun;
import org.personal.mason.competition.utils.Constants;
import org.personal.mason.competition.utils.EmailBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.ClientResponse;

@Controller
@RequestMapping("account")
public class AccountController {
private static final Log log = LogFactory.getLog(AccountController.class);

@Autowired
private AccountService accountService;

@Autowired
private MailGun mailGun;

@RequestMapping(value = "login", method = RequestMethod.POST)
public String login(Account account, HttpSession session, Model model) {
	try {
		Account validateAccount = accountService.validateAccount(account);
		if (validateAccount != null) {
			session.setAttribute(Constants.SESSION_TOKEN, validateAccount.getEmail());
			model.addAttribute("currentUser", validateAccount);
		}
	} catch (Exception e) {
		log.debug("login failed", e);
	}

	return "index";
}

@RequestMapping(value = "logout", method = RequestMethod.GET)
public String logout(HttpSession session, HttpServletResponse response) {
	session.removeAttribute(Constants.SESSION_TOKEN);
	return "redirect:/index";
}

@RequestMapping(value="register", method = RequestMethod.GET)
public String toRegister(Model model) {
	model.addAttribute("account", new Account());
	return "register";
}
@RequestMapping(value="register", method = RequestMethod.POST)
public String register(@Validated Account account, BindingResult result, HttpSession session) {
	try {
		if (result.hasErrors()) {
			return null;
		}
		
		if(accountService.findByEmail(account.getEmail()) != null){
			result.rejectValue("email", "registration.checkingAccountExist", "User exist!");
			return null;
		}
		accountService.createAccount(account);
		ClientResponse response = mailGun.sendMimeMessage(EmailBuilder.buildEmailBody(account.getEmail(), account.getUsername()), "Welcome to OSC Photo Gallay", account.getEmail());
		int status = response.getStatus();
		if(status!= 200){
			log.info("send email failed for account " + account);
		}
		System.out.println(status);
		return "redirect:/index";
	} catch (Exception e) {
		log.debug("regist failed", e);
	}

	return null;
}
}
