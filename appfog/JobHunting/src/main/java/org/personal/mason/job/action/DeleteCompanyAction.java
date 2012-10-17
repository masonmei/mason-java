package org.personal.mason.job.action;

import org.personal.mason.job.service.CompanyService;

public class DeleteCompanyAction extends AbstractAction {

private static final long serialVersionUID = -459758637791092170L;

private CompanyService companyService;
private String msg;
private boolean success;

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

@Override
public String process() {
	try {
		String parameter = request.getParameter("id");
		if (parameter != null) {
			companyService.deleteById(Long.parseLong(parameter));
			msg = "delete success";
			success = true;
			return SUCCESS;
		}
		msg = "nothing to delete";
		success = true;
	} catch (NumberFormatException e) {
		log.debug("delete failed", e);
	}
	return null;
}

}
