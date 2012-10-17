package org.personal.mason.job.action;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.service.CompanyService;

import com.opensymphony.xwork2.ModelDriven;

public class SaveCompanyAction extends AbstractAction implements ModelDriven<Company>{

private static final long serialVersionUID = -4433915271636666179L;

private Company company;
private CompanyService companyService;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

@Override
public String process() {
	try {
		companyService.save(company);
		msg = "Save Company Success";
		success = true;
	} catch (Exception e) {
		log.debug("save company failed", e);
	}
	return "result";
}

@Override
public Company getModel() {
	return company;
}

}
