package org.personal.mason.job.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.News;
import org.personal.mason.job.service.CompanyService;
import org.personal.mason.job.service.NewsService;
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
public String listCompanyNews(@RequestParam("companyId") Long companyId, Integer start, Integer length, Map<String, Object> map) {
	Company company = companyService.findById(companyId);
	if (start == null || start < 0) {
		start = 0;
	}

	if (length == null || length <= 0) {
		length = 10;
	}
	List<News> companyNews = newsService.findCompanyNews(company, start, length);
	map.put("company", company);
	map.put("companyNews", companyNews);
	return "news_list";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addCompanyNews(@RequestParam("companyId") Long companyId, Map<String, Object> map) {
	map.put("companyId", companyId);
	map.put("news", new News());
	return "news_add";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveCompanyNews(@RequestParam("companyId") Long companyId, News news) {
	Company company = companyService.findById(companyId);
	news.setCompany(company);
	newsService.save(news);
	return "redirect:/news/list?companyId=" + companyId;
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewCompanyNews(@RequestParam("id") Long id, Map<String, Object> map) {
	News news = newsService.findById(id);
	map.put("news", news);
	return "news";
}

@RequestMapping(value = "/delete")
public String deleteCompanyNews(@RequestParam("id") Long id, @RequestParam("companyId") Long companyId) {
	newsService.deleteById(id);
	return "redirect:/news/list?companyId=" + companyId;
}
}
