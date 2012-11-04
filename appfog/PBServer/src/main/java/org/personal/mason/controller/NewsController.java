package org.personal.mason.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.domain.Company;
import org.personal.mason.domain.News;
import org.personal.mason.service.CompanyService;
import org.personal.mason.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/news")
public class NewsController {

@Autowired
private CompanyService companyService;

@Autowired
private NewsService newsService;

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public void setNewsService(NewsService newsService) {
	this.newsService = newsService;
}

@InitBinder
public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setLenient(false);
	binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listCompanyNews(@RequestParam("companyId") String companyId, Integer page, Integer size,
		Map<String, Object> map) {
	Company company = companyService.findById(companyId);
	if (page == null || page < 0) {
		page = 0;
	}

	if (size == null || size <= 0) {
		size = 10;
	}

	List<News> companyNews;

	if (company.getNewses().size() <= (page + 1) * 10) {
		companyNews = company.getNewses().subList(page * size, company.getNewses().size());
	} else {
		companyNews = company.getNewses().subList(page * size, (page + 1) * size);
	}
	map.put("company", company);
	map.put("companyNews", companyNews);
	return "news_list";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addCompanyNews(@RequestParam("companyId") String companyId, Map<String, Object> map) {
	map.put("companyId", companyId);
	map.put("news", new News());
	return "news_add";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveCompanyNews(@RequestParam("companyId") String companyId, News news) {
	newsService.save(news);
	companyService.addNewsToCompany(companyId, news);
	return "redirect:/news/list?companyId=" + companyId;
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewCompanyNews(@RequestParam("id") String id, Map<String, Object> map) {
	News news = newsService.findById(id);
	map.put("news", news);
	return "news";
}

@RequestMapping(value = "/delete")
public String deleteCompanyNews(@RequestParam("id") String id, @RequestParam("companyId") String companyId) {
	newsService.delete(id);
	return "redirect:/news/list?companyId=" + companyId;
}
}
