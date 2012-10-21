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

public CompanyService getCompanyService() {
	return companyService;
}

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public List<Company> getCompanies() {
	return companies;
}

public void setCompanies(List<Company> companies) {
	this.companies = companies;
}

public int getPage() {
	return page;
}

public void setPage(int page) {
	this.page = page;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

@Override
public String process() {
	try {
		
		if (pageSize <= 0 || page < 0) {
			companies = companyService.findInScope(0, 10);
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
