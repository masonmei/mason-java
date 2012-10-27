package org.personal.mason.job.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Job;
import org.personal.mason.job.service.CompanyService;
import org.personal.mason.job.service.JobService;
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
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	dateFormat.setLenient(false);
	binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listCompanyJobs(@RequestParam("companyId") Long companyId, Integer start, Integer length, Map<String, Object> map) {
	Company company = companyService.findById(companyId);
	if (start == null || start < 0) {
		start = 0;
	}

	if (length == null || length <= 0) {
		length = 10;
	}
	List<Job> companyJobs = jobService.findCompanyJobs(company, start, length);
	map.put("company", company);
	map.put("companyJobs", companyJobs);
	return "jobs";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addCompanyJob(@RequestParam("companyId") Long companyId, Map<String, Object> map) {
	map.put("companyId", companyId);
	map.put("job", new Job());
	return "job_add";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveCompanyJob(@RequestParam("companyId") Long companyId, Job job) {
	Company company = companyService.findById(companyId);
	job.setCompany(company);
	jobService.save(job);
	return "redirect:/job/list?companyId=" + companyId;
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewCompanyJob(@RequestParam("id") Long id, Map<String, Object> map) {
	Job job = jobService.findById(id);
	map.put("job", job);
	return "job";
}

@RequestMapping(value = "/delete")
public String deleteCompanyJob(@RequestParam("id") Long id, @RequestParam("companyId") Long companyId) {
	jobService.deleteById(id);
	return "redirect:/job/list?companyId=" + companyId;
}
}
