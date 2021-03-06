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
import org.personal.mason.domain.Label;
import org.personal.mason.service.CompanyService;
import org.personal.mason.service.LabelService;
import org.personal.mason.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@Path("/company")
public class CompanyResource {

@Autowired
private CompanyService companyService;

@Autowired
private LabelService labelService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Company> listCompany(@QueryParam("page") Integer startIndex, @QueryParam("size") Integer pageSize) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	Page<Company> companies = companyService.findInScope(startIndex, pageSize);
	return CollectionUtils.pageToList(companies);
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/delete")
public void deleteCompany(@QueryParam("id") String id) {
	companyService.deleteById(id);
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/get")
public Company viewCompany(@QueryParam("id") String id) {
	Company com = companyService.findById(id);
	return com;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/save")
public Company newCompany(Company company) {
	return companyService.save(company);
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/label/add")
public boolean addLabelToCompany(@QueryParam("label") String labelName, @QueryParam("companyId") String companyId) {
	Label label = labelService.findByLabelName(labelName);
	if (label == null) {
		label = new Label();
		label.setLabelName(labelName);
		labelService.save(label);
	}

	return companyService.addLabelToCompany(companyId, label);
}

}
