package org.personal.mason.job.action;

import java.util.ArrayList;
import java.util.List;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Product;
import org.personal.mason.job.service.CompanyService;

public class GetCompanayProductsAction extends AbstractAction {

private static final long serialVersionUID = -5971378838043903508L;
private CompanyService companyService;
private List<Product> products;

public List<Product> getProducts() {
	return products;
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
				products = new ArrayList<Product>(com.getProducts());
				return SUCCESS;
			}
		}
	} catch (NumberFormatException e) {
		log.debug("get company products failed", e);
	}
	return null;
}

}
