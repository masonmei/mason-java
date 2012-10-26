package org.personal.mason.job.controller;

import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Job;
import org.personal.mason.job.service.CompanyService;
import org.personal.mason.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listCompanyJobs(@RequestParam("companyId") Long companyId, Integer start, Integer length, Map<String, Object> map){
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
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompanyNews(@RequestParam("companyId") Long companyId, Job job){
		Company company = companyService.findById(companyId);
		job.setCompany(company);
		jobService.save(job);
		return null;
	}
	
	@RequestMapping(value="/delete")
	public String deleteNews(@RequestParam("id") Long id){
		jobService.deleteById(id);
		return null;
	}
}
