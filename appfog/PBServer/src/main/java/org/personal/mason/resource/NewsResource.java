package org.personal.mason.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.personal.mason.domain.Company;
import org.personal.mason.domain.News;
import org.personal.mason.service.CompanyService;
import org.personal.mason.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/news")
public class NewsResource {
@Autowired
private CompanyService companyService;

@Autowired
private NewsService newsService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<News> listCompanyNews(@QueryParam("companyId") String companyId, @QueryParam("page") Integer page,
		@QueryParam("size") Integer size) {
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
	return companyNews;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/save")
public News saveCompanyNews(@QueryParam("companyId") String companyId, News news) {
	News savedNews = newsService.save(news);
	companyService.addNewsToCompany(companyId, news);
	return savedNews;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/get")
public News viewCompanyNews(@QueryParam("id") String id) {
	return newsService.findById(id);
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/delete")
public void deleteCompanyNews(@QueryParam("id") String id) {
	newsService.delete(id);
}
}
