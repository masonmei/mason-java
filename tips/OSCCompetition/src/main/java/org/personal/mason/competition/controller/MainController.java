package org.personal.mason.competition.controller;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.personal.mason.competition.domain.Account;
import org.personal.mason.competition.domain.Category;
import org.personal.mason.competition.domain.Image;
import org.personal.mason.competition.service.AccountService;
import org.personal.mason.competition.service.CategoryService;
import org.personal.mason.competition.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

@Autowired
private CategoryService categoryService;

@Autowired
private AccountService accountService;

@RequestMapping(value = "/", method = RequestMethod.GET)
public String root() {
	return "redirect:index";
}

@RequestMapping(value = "index", method = RequestMethod.GET)
public String index(HttpSession session, Model model) {
	if (session != null && session.getAttribute(Constants.SESSION_TOKEN) != null) {
		String accountId = (String) session.getAttribute(Constants.SESSION_TOKEN);
		Account account = accountService.findById(accountId);
		List<Category> allCategory = categoryService.findAllByAccount(account);
		model.addAttribute("currentUser", account);
		model.addAttribute("categories", allCategory);
		model.addAttribute("category", new Category());
	} else {
		model.addAttribute("account", new Account());
	}

	return "index";
}

@RequestMapping(value = "images", method = RequestMethod.GET)
public String getImages(HttpSession session, Model model) {
	if (session != null && session.getAttribute(Constants.SESSION_TOKEN) != null) {
		String id = (String) session.getAttribute(Constants.SESSION_TOKEN);
		Account account = accountService.findById(id);
		List<Category> publicPrivilegeCategories = categoryService.getPublicPrivilegeCategories(account);
		if (publicPrivilegeCategories.size() > 0) {
			model.addAttribute("images", publicPrivilegeCategories.get(0).getImages());
		}
	} else {
		model.addAttribute("images", getPublicImages());
	}
	return "images";
}

private List<Image> getPublicImages() {
	Random random = new Random();
	List<Category> publicPrivilegeCategories = categoryService.getPublicPrivilegeCategories();
	if (publicPrivilegeCategories.size() > 0) {
		return publicPrivilegeCategories.get(random.nextInt(publicPrivilegeCategories.size())).getImages();
	}
	return Collections.emptyList();
}

}
