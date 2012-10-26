package org.personal.mason.job.controller;

import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.News;
import org.personal.mason.job.service.CompanyService;
import org.personal.mason.job.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listCompanyNewsList(@RequestParam("companyId") Long companyId, Integer start, Integer length, Map<String, Object> map){
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
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompanyNews(@RequestParam("companyId") Long companyId, News news){
		Company company = companyService.findById(companyId);
		news.setCompany(company);
		newsService.save(news);
		return null;
	}
	
	@RequestMapping(value="/delete")
	public String deleteNews(@RequestParam("id") Long id){
		newsService.deleteById(id);
		return null;
	}
}
