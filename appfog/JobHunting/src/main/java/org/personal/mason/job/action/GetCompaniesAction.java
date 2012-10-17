package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.service.CompanyService;

public class GetCompaniesAction extends AbstractAction {
private static final long serialVersionUID = 4139719727279663575L;


private CompanyService companyService;
private List<Company> companies;
private int page;
private int pageSize;

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public List<Company> getCompanies() {
	return this.companies;
}

public void setPage(int page) {
	this.page = page;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

@Override
public String process() {
	try {
		if (pageSize <= 0 || page < 0) {
			companies = companyService.findAll();
		} else {
			companies = companyService.findInScope(page * pageSize, pageSize);
		}
		
		return SUCCESS;
	} catch (Exception e) {
		log.debug("cannot get companies", e);
	}
	return null;
}

}
