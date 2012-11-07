package org.personal.mason.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.domain.User;
import org.personal.mason.dto.UserForm;
import org.personal.mason.service.UserService;
import org.personal.mason.thirdparty.MailGun;
import org.personal.mason.utils.EmailBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.ClientResponse;

@Controller
@RequestMapping("/register")
public class UserController {

private static final Log log = LogFactory.getLog(UserController.class);

@Autowired
private UserService userService;

@Autowired
private MailGun mailGun;

@RequestMapping(method = RequestMethod.GET)
public void toRegister(Model model) {
	model.addAttribute("userForm", new UserForm());
}

@RequestMapping(method = RequestMethod.POST)
public String register(@Validated UserForm userForm, BindingResult result, HttpSession session) {
	try {
		if (result.hasErrors()) {
			return null;
		}
		String validatecode = (String) session.getAttribute("validationcode");
		if (validatecode == null || !validatecode.equalsIgnoreCase(userForm.getValidationCode())) {
			result.rejectValue("validationCode", "registration.checkingValidationCode", "Password not match!");
			return null;
		}

		if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
			result.rejectValue("passwordConfirm", "registration.matchingPassword", "Password not match!");
		}

		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setName(userForm.getName());
		user.setPassword(userForm.getPassword());
		if(userService.findByEmail(user.getEmail()) != null){
			result.rejectValue("email", "registration.checkingAccountExist", "User exist!");
			return null;
		}
		userService.register(user);
		ClientResponse response = mailGun.sendMimeMessage(EmailBuilder.buildEmailBody(userForm.getEmail(), userForm.getName()), "Welcome to PBM", userForm.getEmail());
		int status = response.getStatus();
		if(status!= 200){
			log.info("send email failed for user " + user);
		}
		System.out.println(status);
		return "redirect:index";
	} catch (Exception e) {
		log.debug("regist failed", e);
	}

	return null;
}
}
