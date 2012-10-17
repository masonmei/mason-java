package org.personal.mason.job.action;

import java.util.ArrayList;
import java.util.List;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.News;
import org.personal.mason.job.service.CompanyService;

public class GetCompanyNewsAction extends AbstractAction {

private static final long serialVersionUID = 2942061823963321069L;

private CompanyService companyService;
private List<News> news;

public List<News> getNews() {
	return news;
}

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

@Override
public String process() {
	try {
		String parameter = request.getParameter("id");
		if (parameter != null) {
			Company com = companyService.findById(Long.parseLong(parameter));
			if (com != null) {
				news = new ArrayList<News>(com.getNewses());
				return SUCCESS;
			}
		}
	} catch (NumberFormatException e) {
		log.debug("get company news failed", e);
	}
	return null;
}

}
