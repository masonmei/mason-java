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
import org.personal.mason.domain.Job;
import org.personal.mason.service.CompanyService;
import org.personal.mason.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Path("/job")
public class JobResource {
@Autowired
private JobService jobService;
@Autowired
private CompanyService companyService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Job> listCompanyJobs(@QueryParam("companyId") String companyId, @QueryParam("page") Integer page,
		@QueryParam("size") Integer size) {
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

	return companyJobs;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/save")
@RequestMapping(value = "/save", method = RequestMethod.POST)
public Job saveCompanyJob(@QueryParam("companyId") String companyId, Job job) {
	Job savedJob = jobService.save(job);
	companyService.addJobToCompany(companyId, job);
	return savedJob;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/get")
public Job viewCompanyJob(@QueryParam("id") String id) {
	return jobService.findById(id);
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/delete")
public void deleteCompanyJob(@QueryParam("id") String id, @QueryParam("companyId") String companyId) {
	Company company = companyService.findById(companyId);
	for (Job j : company.getJobs()) {
		if (j.getId().equals(id)) {
			company.getJobs().remove(j);
			break;
		}
	}
	companyService.save(company);
	jobService.delete(id);
}
}
