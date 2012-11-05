package org.personal.mason.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.domain.Company;
import org.personal.mason.domain.Job;
import org.personal.mason.service.CompanyService;
import org.personal.mason.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/job")
public class JobController {
@Autowired
private CompanyService companyService;

@Autowired
private JobService jobService;

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public void setJobService(JobService jobService) {
	this.jobService = jobService;
}

@InitBinder
public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setLenient(false);
	binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listCompanyJobs(@RequestParam("companyId") String companyId, Integer page, Integer size,
		Map<String, Object> map) {
	Company company = companyService.findById(companyId);
	if (page == null || page < 0) {
		page = 0;
	}

	if (size == null || size <= 0) {
		size = 10;
	}
	List<Job> companyJobs;

	if (company.getNewses().size() <= (page + 1) * 10) {
		companyJobs = company.getJobs().subList(page * size, company.getJobs().size());
	} else {
		companyJobs = company.getJobs().subList(page * size, (page + 1) * size);
	}
	map.put("company", company);
	map.put("companyJobs", companyJobs);
	return "jobs";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addCompanyJob(@RequestParam("companyId") String companyId, Map<String, Object> map) {
	map.put("companyId", companyId);
	map.put("job", new Job());
	return "job_add";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveCompanyJob(@RequestParam("companyId") String companyId, Job job) {
	jobService.save(job);
	companyService.addJobToCompany(companyId, job);
	return "redirect:list?companyId=" + companyId;
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewCompanyJob(@RequestParam("id") String id, Map<String, Object> map) {
	Job job = jobService.findById(id);
	map.put("job", job);
	return "job";
}

@RequestMapping(value = "/delete")
public String deleteCompanyJob(@RequestParam("id") String id, @RequestParam("companyId") String companyId) {
	jobService.delete(id);
	return "redirect:list?companyId=" + companyId;
}
}
