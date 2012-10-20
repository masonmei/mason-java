package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Label;
import org.personal.mason.job.service.CompanyService;
import org.personal.mason.job.service.LabelService;

public class GetCompanysWithLabelAction extends AbstractAction {

private static final long serialVersionUID = -5748429216540550571L;
private CompanyService companyService;
private LabelService labelService;
private List<Company> companies;
private String labelName;
private int page;
private int pageSize;
private String msg;

public List<Company> getCompanies() {
	return companies;
}

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public void setLabelService(LabelService labelService) {
	this.labelService = labelService;
}

public void setLabelName(String labelName) {
	this.labelName = labelName;
}

public void setPage(int page) {
	this.page = page;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public String getMsg() {
	return msg;
}

@Override
public String process() {
	try {
		Label label = new Label();
		label.setLabelName(labelName);
		List<Label> labels = labelService.findByExample(label);
		if (labels == null || labels.isEmpty()) {
			msg = "no label with this name";
			return null;
		}

		if (pageSize <= 0 || page <= 0) {
			companies = companyService.findByLabel(labels.get(0));
		} else {
			companies = companyService.findByLabel(labels.get(0), page * pageSize, pageSize);
		}
		return SUCCESS;
	} catch (Exception e) {
		log.debug("cannot get offers", e);
	}
	return null;
}

}
