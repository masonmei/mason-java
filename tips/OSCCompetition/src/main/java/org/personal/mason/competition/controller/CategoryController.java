package org.personal.mason.competition.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import org.personal.mason.competition.domain.Account;
import org.personal.mason.competition.domain.Category;
import org.personal.mason.competition.domain.Image;
import org.personal.mason.competition.service.AccountService;
import org.personal.mason.competition.service.CategoryService;
import org.personal.mason.competition.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("category")
public class CategoryController {
private static final int PAGE_SIZE = 12;

@Autowired
private CategoryService categoryService;

@Autowired
private AccountService accountService;

@RequestMapping(value = "images", method = RequestMethod.GET)
public String getCategoryImages(@QueryParam("id") String id, @QueryParam("page") int page, HttpSession session, Model model) {
	if(session!= null && session.getAttribute(Constants.SESSION_TOKEN) != null){
		Category category = categoryService.findById(id);
		
		if(category != null){
			List<Image> images = category.getImages();
			int prePage = -1;
			int nextPage = -1;
			int fromIndex = page * PAGE_SIZE;
			if(images.size() > PAGE_SIZE + fromIndex){
				prePage = page;
				nextPage = page + 1;
			}else if(images.size() == PAGE_SIZE + fromIndex){
				prePage = page;
			}
			
			if(page == 0){
				prePage = -1;
			}
			
			model.addAttribute("prePage", prePage);
			model.addAttribute("nextPage", nextPage);
			model.addAttribute("categoryId", id);
						
			int toIndex = fromIndex + PAGE_SIZE;
			
			if(images.size() <= toIndex){
				toIndex = images.size();
			}
			
			model.addAttribute("images", images.subList(fromIndex, toIndex));
		}
		return "images";
	}
	return "redirect:/index";
}

@RequestMapping(value = "list", method = RequestMethod.GET)
public String getCategories(HttpSession session, Model model) {
	if (session != null && session.getAttribute(Constants.SESSION_TOKEN) != null) {
		String accountId = (String) session.getAttribute(Constants.SESSION_TOKEN);
		Account account = accountService.findById(accountId);
		List<Category> allCategory = categoryService.findAllByAccount(account);
		model.addAttribute("categories", allCategory);
		model.addAttribute("category", new Category());
	}
	return "menu";
}

@RequestMapping(value = "add", method = RequestMethod.POST)
public String addCategories(@Validated Category category, HttpSession session, Model model) {
	if (session != null && session.getAttribute(Constants.SESSION_TOKEN) != null) {
		String accountId = (String) session.getAttribute(Constants.SESSION_TOKEN);
		Account account = accountService.findById(accountId);

		if (account != null) {
			category.setAccount(account);
			categoryService.createCategory(category);
		}
	}
	return "redirect:/index";
}

}
